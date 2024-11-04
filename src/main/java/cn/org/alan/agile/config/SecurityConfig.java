package cn.org.alan.agile.config;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.filter.VerifyTokenFilter;
import cn.org.alan.agile.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * Spring Security 权限配置
 *
 * @author Alan
 * @since 2024/4/17
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Resource
    private ResponseUtil responseUtil;
    @Resource
    private VerifyTokenFilter verifyTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authorize) -> authorize
                        // 放开认证
                        .requestMatchers(new AntPathRequestMatcher("/api/auths/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/auths/logout")).authenticated()
                        // 所有请求的授权都需要认证
                        .anyRequest().authenticated()
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                )
                .httpBasic().disable()
                .formLogin(AbstractHttpConfigurer::disable
                );

        // 配置拒绝访问处理器
        http.exceptionHandling((exceptions) -> exceptions
                .accessDeniedHandler((request, response, accessDeniedException) ->
                        responseUtil.response(response, Result.failed("你没有该资源的访问权限")))
        );

        // 配置请求拦截前处理器，验证token
        http.addFilterBefore(verifyTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 放开跨域请求
        http.csrf((csrf) -> csrf.disable());

        return http.build();


    }

    /**
     * 不走过滤器链的放行配置
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(
                        new AntPathRequestMatcher("/api/auths/**"),
                        new AntPathRequestMatcher("/webjars/**"),
                        new AntPathRequestMatcher("/doc.html"),
                        new AntPathRequestMatcher("/swagger-resources/**"),
                        new AntPathRequestMatcher("/v3/api-docs/**"),
                        new AntPathRequestMatcher("/swagger-ui/**"),
                        new AntPathRequestMatcher("/swagger-ui.html"),
                        new AntPathRequestMatcher("/ws/**"),
                        new AntPathRequestMatcher("/ws-app/**"),
                        new AntPathRequestMatcher("/api/teams", HttpMethod.POST.name()),
                        new AntPathRequestMatcher("/api/teams/addTeam", HttpMethod.POST.name())
                );
    }

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManager 手动注入
     *
     * @param authenticationConfiguration 认证配置
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
