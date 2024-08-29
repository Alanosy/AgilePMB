package cn.org.alan.agile.controller;


import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.auth.LoginForm;
import cn.org.alan.agile.model.form.user.UserForm;
import cn.org.alan.agile.model.vo.auth.AuthLoginVo;
import cn.org.alan.agile.service.IAuthService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限管理
 *
 * @Author Aalan
 * @Version
 * @Date 2024/8/25 11:05 AM
 */
@RestController
@RequestMapping("/api/auths")
public class AuthController {

    @Resource
    private IAuthService iAuthService;


    /**
     * 用户登录
     * @param request
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public Result<AuthLoginVo> login(HttpServletRequest request,
                                     @Validated @RequestBody LoginForm loginForm) {

        return iAuthService.login(request,loginForm);
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @DeleteMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        return iAuthService.logout(request);
    }

    /**
     * 用户注册
     * @param request
     * @param userForm
     * @return
     */
    @PostMapping("/register")
    public Result register(HttpServletRequest request,
                                   @RequestBody UserForm userForm) {
        return iAuthService.register(request, userForm);
    }

    /**
     * 获取图片验证码
     * @param request
     * @param response
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        iAuthService.getCaptcha(request, response);
    }

    /**
     * 校验验证码
     * @param request
     * @param code
     * @return
     */
    @PostMapping("/verifyCode/{code}")
    public Result<String> verifyCode(HttpServletRequest request, @PathVariable("code") String code) {
        return iAuthService.verifyCode(request, code);
    }


}
