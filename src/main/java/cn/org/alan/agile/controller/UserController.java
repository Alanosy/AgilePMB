package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.form.team.TeamAddForm;
import cn.org.alan.agile.model.form.user.MyselfDataPutForm;
import cn.org.alan.agile.model.form.user.UserForm;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import cn.org.alan.agile.service.TProjectsService;
import cn.org.alan.agile.service.TUsersService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:31 PM
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private TUsersService tUsersService;

    /**
     * 用户选择
     * @return
     */
    @GetMapping("/fetchUsers")
    public Result<List<fetchUsersVo>> fetchUsers(){
        List<fetchUsersVo> usersList = tUsersService.fetchUsers();
        return Result.success("请求成功",usersList);
    }

    /**
     * 个人信息
     * @return
     */
    @GetMapping("/myself-data")
    public Result getMyselfData(){
        Result  result = tUsersService.getMyselfData();
        return result;
    }

    /**
     * 修改个人信息
     * @param myselfDataPutForm
     * @return
     */
    @PutMapping("/updateMyselfData")
    public Result updateMyselfData(@RequestBody MyselfDataPutForm myselfDataPutForm){
        Result  result = tUsersService.updateMyselfData(myselfDataPutForm);
        return result;
    }

    /**
     * 用户修改密码
     *
     * @param userForm 入参
     * @return 响应结果
     */
    @PutMapping("/updatePw")
    public Result<String> updatePassword(@RequestBody UserForm userForm) {
        return tUsersService.updatePassword(userForm);
    }
}
