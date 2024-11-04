package cn.org.alan.agile.filter;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.AuthConverter;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.vo.auth.LoginVo;
import cn.org.alan.agile.security.SysUserDetails;
import cn.org.alan.agile.util.JwtUtil;
import cn.org.alan.agile.util.ResponseUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Alan
 * @Version 1.0
 * @Date 2024/3/25 19:50
 */
@Slf4j
@Component
public class VerifyTokenFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private ResponseUtil responseUtil;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private AuthConverter authConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 登录、注册、校验验证码、获取验证码、放行
        String uri = request.getRequestURI();
        if ((uri.contains("login") || uri.contains("verifyCode")
                || uri.contains("captcha") || uri.contains("register"))
                || uri.equals("/api/teams") || uri.equals("/api/teams/addTeam") ){
            doFilter(request, response, filterChain);
            return;
        }

        // 获取jwt令牌
        String authorization = request.getHeader("Authorization");
        // 判断是否为空
        if (StringUtils.isBlank(authorization)) {
            responseUtil.response(response, Result.failed("Authorization为空，请先登录"));
            return;
        }
        // 校验jwt是否过期
        boolean verify = jwtUtil.verifyToken(authorization);
        if (!verify) {
            responseUtil.response(response, Result.failed("token已过期，请重新登录"));
            return;
        }
        String id = request.getSession().getId();
        // 反序列化token
        String userInfo = jwtUtil.getUser(authorization);

        // 反序列化权限列表
        List<String> authList = jwtUtil.getAuthList(authorization);
        // 反序列化jwtToken获取用户信息
        LoginVo sysUser = objectMapper.readValue(userInfo, LoginVo.class);
        // 权限转型
        List<SimpleGrantedAuthority> permissions = authList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        // 创建登录用户
        TUsers tUsers = authConverter.VoToEntity(sysUser);
        SysUserDetails securityUser = new SysUserDetails(tUsers);
        securityUser.setPermissions(permissions);
        securityUser.setTeamId(sysUser.getTeamId());
        securityUser.setRole(sysUser.getRole());
        // 创建权限授权的token 参数：用户，密码，权限 不给密码因为已经登录了
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(securityUser, null, null);
        // 通过安全上下文设置授权token
        SecurityContextHolder.getContext().setAuthentication(token);
        // 放行
        doFilter(request, response, filterChain);
    }
}
