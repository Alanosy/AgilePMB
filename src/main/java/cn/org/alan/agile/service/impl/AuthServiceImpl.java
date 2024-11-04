package cn.org.alan.agile.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.AuthConverter;
import cn.org.alan.agile.converter.TUsersConverter;
import cn.org.alan.agile.mapper.TTeamsMapper;
import cn.org.alan.agile.mapper.TUserTeamMapper;
import cn.org.alan.agile.mapper.TUsersMapper;
import cn.org.alan.agile.model.entity.TTeams;
import cn.org.alan.agile.model.entity.TUserTeam;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.form.auth.LoginForm;
import cn.org.alan.agile.model.form.user.UserForm;
import cn.org.alan.agile.model.vo.auth.AuthLoginVo;
import cn.org.alan.agile.model.vo.auth.LoginVo;
import cn.org.alan.agile.model.vo.user.registerVo;
import cn.org.alan.agile.security.SysUserDetails;
import cn.org.alan.agile.service.IAuthService;
import cn.org.alan.agile.util.JwtUtil;
import cn.org.alan.agile.util.SecretUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @Author Alan
 * @Version
 * @Date 2024/3/28 1:33 PM
 */
@Service
public class AuthServiceImpl implements IAuthService {
    private static final String HEARTBEAT_KEY_PREFIX = "user:heartbeat:";
    private static final long HEARTBEAT_INTERVAL_MILLIS = 10 * 60 * 1000; // 10分钟

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private TUsersMapper tUsersMapper;
    // @Resource
    // private RoleMapper roleMapper;
    @Resource
    private TUsersConverter tUsersConverter;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private AuthConverter authConverter;
    @Resource
    private TUserTeamMapper tUserTeamMapper;
    @Resource
    private TTeamsMapper tTeamsMapper;

    private static final String IS_VERIFY_CODE_PREFIX = "isVerifyCode";
    /**
     * 登录
     * @param request
     * @param loginForm 入参
     * @return 响应
     */
    @SneakyThrows(JsonProcessingException.class)
    @Override
    public Result<AuthLoginVo> login(HttpServletRequest request, LoginForm loginForm) {
        // 检查验证码是否已验证
        String isVerifyCodeKey = IS_VERIFY_CODE_PREFIX + request.getSession().getId();
        String isVerifyCodeValue = stringRedisTemplate.opsForValue().get(isVerifyCodeKey);
        if (StringUtils.isBlank(isVerifyCodeValue)) {
            return Result.failed("请先验证验证码");
        }

        // 根据用户名获取用户信息
        LambdaQueryWrapper<TUsers> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TUsers::getUsername, loginForm.getUsername());
        TUsers user = tUsersMapper.selectOne(wrapper);
        // 判读用户名是否存在
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(loginForm.getPassword(), user.getPassword())) {
            return Result.failed("密码错误");
        }
        user.setPassword(null);

        // 把转型后的权限放进sysUserDetails对象
        LoginVo loginVo = authConverter.entityToEV(user);
        // 查询是否加有有关联团队
        Integer teamState = determineTeamState(user);
        if (teamState == 1) {
            TUserTeam tUserTeam = getCurrentTeam(user);
            loginVo.setTeamId(tUserTeam.getTid());
            if (isAdmin(tUserTeam,user)) {
                loginVo.setRole("admin");
            } else {
                loginVo.setRole("employee");
            }
        }
        // 创建一个sysUserDetails对象，该类实现了UserDetails接口
        SysUserDetails sysUserDetails = new SysUserDetails(user);
        // 权限列表
        List<String> permissions = new ArrayList<>();
        permissions.add(loginVo.getRole());
        // 数据库获取的权限是字符串springSecurity需要实现GrantedAuthority接口类型，所有这里做一个类型转换
        List<SimpleGrantedAuthority> userPermissions = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority("role_" + permission))
                .collect(Collectors.toList());
        sysUserDetails.setPermissions(userPermissions);
        // 将用户信息转为字符串并创建token
        String userInfo = objectMapper.writeValueAsString(loginVo);
        String token = jwtUtil.createJwt(userInfo, userPermissions.stream().map(String::valueOf).collect(Collectors.toList()));
        // 把token放到redis中
        stringRedisTemplate.opsForValue().set("token" + request.getSession().getId(), token, 24, TimeUnit.HOURS);
        // 封装用户的身份信息，为后续的身份验证和授权操作提供必要的输入
        // 创建UsernamePasswordAuthenticationToken  参数：用户信息，密码，权限列表userPermissions
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(sysUserDetails, user.getPassword(), userPermissions );

        // 可选，添加Web认证细节
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // 用户信息存放进上下文
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // 清除redis通过校验表示
        stringRedisTemplate.delete("isVerifyCode" + request.getSession().getId());
        AuthLoginVo authLoginVo = new AuthLoginVo();
        authLoginVo.setToken(token);
        authLoginVo.setTeamState(teamState);
        return Result.success("登录成功", authLoginVo);
    }

    // 判断用户是否为管理员
    private boolean isAdmin(TUserTeam tUserTeam,TUsers user) {
        LambdaQueryWrapper<TTeams> tTeamsQueryWrapper = new LambdaQueryWrapper<>();
        tTeamsQueryWrapper.eq(TTeams::getId, tUserTeam.getTid());
        TTeams tTeams = tTeamsMapper.selectOne(tTeamsQueryWrapper);
        return tTeams.getUserid().equals(user.getId());
    }

    // 获取当前用户所在的团队信息
    private TUserTeam getCurrentTeam(TUsers user) {
        LambdaQueryWrapper<TUserTeam> tUserTeamQueryWrapper = new LambdaQueryWrapper<>();
        tUserTeamQueryWrapper.eq(TUserTeam::getUid, user.getId())
                .eq(TUserTeam::getState, 1);
        return tUserTeamMapper.selectOne(tUserTeamQueryWrapper);
    }

    // 确定用户的团队状态
    private Integer determineTeamState(TUsers user) {
        LambdaQueryWrapper<TUserTeam> tUserTeamQueryWrapper = new LambdaQueryWrapper<>();
        tUserTeamQueryWrapper.eq(TUserTeam::getUid, user.getId());
        List<TUserTeam> tUserTeams = tUserTeamMapper.selectList(tUserTeamQueryWrapper);
        if (tUserTeams.size() == 0) {
            // 没有团队
            return 0;
        } else if (tUserTeams.size() == 1) {
            TUserTeam tUserTeam = tUserTeams.get(0);
            int state = Integer.parseInt(tUserTeam.getState());
            if (state == 1) {
                // 只有一个团队，刚好是当前团队
                return 1;
            } else if (state == 2) {
                // 只有一个团队，是申请加入团队，还没同意
                return 2;
            } else if (state == 3) {
                // 只有一个团队，是申请加入团队，被拒绝
                return 3;
            }
        } else {
            // 有多个团队，查询当前团队
            tUserTeamQueryWrapper.eq(TUserTeam::getState, 1);
            TUserTeam tUserTeam = tUserTeamMapper.selectOne(tUserTeamQueryWrapper);
            return 1;
        }
        return null;
    }


    @Override
    public Result<String> logout(HttpServletRequest request) {

        // 清除session
        HttpSession session = request.getSession(false);

        if (session != null) {
            // 清除redis
            stringRedisTemplate.delete("token" + session.getId());
            session.invalidate();
        }

        return Result.success("退出成功");
    }


    @SneakyThrows(IOException.class)
    @Override
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 生成线性图形验证码的静态方法，参数：图片宽，图片高，验证码字符个数 干扰个数
        LineCaptcha captcha = CaptchaUtil
                .createLineCaptcha(200, 100, 4, 300);

        // 把验证码存放进redis
        // 获取验证码
        String code = captcha.getCode();
        String key = "code" + request.getSession().getId();
        stringRedisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
        // 把图片响应到输出流
        response.setContentType("image/jpeg");
        ServletOutputStream os = response.getOutputStream();
        captcha.write(os);
        os.close();
    }

    @Override
    public Result<String>  verifyCode(HttpServletRequest request, String code) {
        String key = "code" + request.getSession().getId();
        String rightCode = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(rightCode)) {
            return Result.failed("验证码已过期");
        }
        if (!rightCode.equalsIgnoreCase(code)) {
            return Result.failed("验证码错误");
        }
        // 验证码校验后redis清除验证码，避免重复使用
        stringRedisTemplate.delete(key);
        // 验证码校验后redis存入校验成功，避免用户登录和注册时不验证验证码直接提交
        stringRedisTemplate.opsForValue().set("isVerifyCode" + request.getSession().getId(), "1", 5, TimeUnit.MINUTES);
        return Result.success("验证码校验成功");
    }

    @Override
    public Result register(HttpServletRequest request, UserForm userForm) {

        String s = stringRedisTemplate.opsForValue().get("isVerifyCode" + request.getSession().getId());
        if (StringUtils.isBlank(s)) {
            return Result.failed("请先验证验证码");
        }
        if (!userForm.getPassword().equals(userForm.getCheckedPassword())) {
            return Result.failed("两次密码不一致");
        }
        TUsers user = tUsersConverter.fromToEntity(userForm);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setUsername(userForm.getUserName());
        user.setRealname(userForm.getRealName());
        tUsersMapper.insert(user);
        // 注册成功把redis的是否通过校验验证码删除，防止用户注册后立马登录，还可以使用
        stringRedisTemplate.delete("isVerifyCode" + request.getSession().getId());
        registerVo registerVo = new registerVo();
        registerVo.setUserId(user.getId());
        return Result.success("注册成功",registerVo);
    }
}
