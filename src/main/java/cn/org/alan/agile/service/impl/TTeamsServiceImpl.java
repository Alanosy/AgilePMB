package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.AuthConverter;
import cn.org.alan.agile.mapper.TUserTeamMapper;
import cn.org.alan.agile.mapper.TUsersMapper;
import cn.org.alan.agile.model.entity.TUserTeam;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.form.team.ApplyCheckForm;
import cn.org.alan.agile.model.form.team.CutTeamForm;
import cn.org.alan.agile.model.form.team.TeamAddForm;
import cn.org.alan.agile.model.form.team.TeamSaveForm;
import cn.org.alan.agile.model.vo.auth.LoginVo;
import cn.org.alan.agile.model.vo.team.ApplyTeamGetVo;
import cn.org.alan.agile.model.vo.team.TeamGetVo;
import cn.org.alan.agile.model.vo.team.TeamUserGetVo;
import cn.org.alan.agile.security.SysUserDetails;
import cn.org.alan.agile.util.JwtUtil;
import cn.org.alan.agile.util.SecurityUtil;
import cn.org.alan.agile.util.TeamCodeGenerator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTeams;
import cn.org.alan.agile.service.TTeamsService;
import cn.org.alan.agile.mapper.TTeamsMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
* @author alan
* @description 针对表【T_Teams】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TTeamsServiceImpl extends ServiceImpl<TTeamsMapper, TTeams>
    implements TTeamsService{


    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private TeamCodeGenerator teamCodeGenerator;
    @Resource
    private TTeamsMapper tTeamsMapper;
    @Resource
    private TUserTeamMapper tUserTeamMapper;
    @Resource
    private TUsersMapper tUsersMapper;
    @Resource
    private AuthConverter authConverter;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private ObjectMapper objectMapper;
    @Override
    @Transactional
    public Result saveTeam(TeamSaveForm teamSaveForm) {
        TTeams tTeams = new TTeams();
        tTeams.setName(teamSaveForm.getTeamName());
        tTeams.setUserid(teamSaveForm.getUserId());
        tTeams.setCode(teamCodeGenerator.createTeamCode(18));
        int insert1 = tTeamsMapper.insert(tTeams);
        TUserTeam tUserTeam = new TUserTeam();
        tUserTeam.setState("1");
        tUserTeam.setTid(tTeams.getId());
        tUserTeam.setUid(teamSaveForm.getUserId());
        int insert2 = tUserTeamMapper.insert(tUserTeam);
        if(insert1>0 && insert2 >0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result addTeam(TeamAddForm teamAddForm) {
        LambdaQueryWrapper<TTeams> tTeamsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tTeamsLambdaQueryWrapper.eq(TTeams::getCode,teamAddForm.getTcode());
        TTeams tTeams = tTeamsMapper.selectOne(tTeamsLambdaQueryWrapper);
        TUserTeam tUserTeam = new TUserTeam();
        tUserTeam.setUid(teamAddForm.getUserId());
        tUserTeam.setTid(tTeams.getId());
        tUserTeam.setState("2");
        int insert = tUserTeamMapper.insert(tUserTeam);
        if(insert>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result getTeamPage(Integer pageNum, Integer pageSize, String teamName, String type) {
        Page<TTeams> page = new Page<>(pageNum, pageSize);

        Page<TeamGetVo> result = tUserTeamMapper.getTeamPage(page, teamName,SecurityUtil.getUserId(),type);

        return Result.success("查询成功", result);
    }

    @Override
    public Result getTeamUserPage(Integer pageNum, Integer pageSize, String realName) {
        Page<TTeams> page = new Page<>(pageNum, pageSize);

        Page<TeamUserGetVo> result = tUserTeamMapper.getTeamUserPage(page,SecurityUtil.getTeamId(),realName);

        return Result.success("查询成功", result);
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public Result cutTeam(HttpServletRequest request, CutTeamForm cutTeamForm) {
        // Integer result = tUserTeamMapper.cutTeam(cutTeamForm,SecurityUtil.getTeamId(),SecurityUtil.getUserId());
        LambdaUpdateWrapper<TUserTeam> tUserTeamLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        tUserTeamLambdaUpdateWrapper.eq(TUserTeam::getUid,SecurityUtil.getUserId())
                .eq(TUserTeam::getState,1)
                .set(TUserTeam::getState,0);
        int update = tUserTeamMapper.update(tUserTeamLambdaUpdateWrapper);

        LambdaUpdateWrapper<TUserTeam> lambdaWrapper = new LambdaUpdateWrapper<>();
        lambdaWrapper.eq(TUserTeam::getUid,SecurityUtil.getUserId())
                .eq(TUserTeam::getTid,cutTeamForm.getTeamId())
                .eq(TUserTeam::getState,0)
                .set(TUserTeam::getState,1);
        int update2 = tUserTeamMapper.update(lambdaWrapper);


        // 根据用户名获取用户信息
        LambdaQueryWrapper<TUsers> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TUsers::getId, SecurityUtil.getUserId());
        TUsers user = tUsersMapper.selectOne(wrapper);
        user.setPassword(null);

        // 创建一个sysUserDetails对象，该类实现了UserDetails接口
        SysUserDetails sysUserDetails = new SysUserDetails(user);
        // // 把转型后的权限放进sysUserDetails对象
        // sysUserDetails.setPermissions(userPermissions);
        LoginVo loginVo = authConverter.entityToEV(user);
        loginVo.setTeamId(cutTeamForm.getTeamId());
        // 查询团队
        LambdaQueryWrapper<TTeams> tTeamsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tTeamsLambdaQueryWrapper.eq(TTeams::getId,cutTeamForm.getTeamId());
        TTeams tTeams = tTeamsMapper.selectOne(tTeamsLambdaQueryWrapper);
        //判断团队是否是自己创建
        if(tTeams.getUserid().equals(user.getId())){
            loginVo.setRole("admin");
        }else{
            loginVo.setRole("employee");
        }
        List<String> permissions = new ArrayList<>();
        permissions.add(loginVo.getRole());
        // 数据库获取的权限是字符串springSecurity需要实现GrantedAuthority接口类型，所有这里做一个类型转换，权限列表
        List<SimpleGrantedAuthority> userPermissions = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority("role_" + permission))
                .collect(Collectors.toList());
        // 将用户信息转为字符串
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
        //用户信息放入
        return Result.success("切换团队成功", token);
    }

    @Override
    public Result getApplyTeamPage(Integer pageNum, Integer pageSize, String userName) {
        Page<TUserTeam> page = new Page<>(pageNum, pageSize);
        Page<ApplyTeamGetVo> result = tUserTeamMapper.getApplyTeamPage(page,SecurityUtil.getTeamId(),SecurityUtil.getUserId(),userName);
        return Result.success("查询成功", result);
    }

    @Override
    public Result applyCheck(ApplyCheckForm applyCheckForm) {
        Integer state = null;
        if("0".equals(applyCheckForm.getState())){
            state = 3;
        } else if ("1".equals(applyCheckForm.getState())) {
            state = 0;
        }


        int result = tUserTeamMapper.applyCheck(applyCheckForm.getTeamId(),applyCheckForm.getUserId(),state);
        if(result>0){
            return Result.success("更新成功");
        }
        return Result.failed("更新成功");
    }
}




