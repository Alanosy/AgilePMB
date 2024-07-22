package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import cn.org.alan.agile.service.TProjectsService;
import cn.org.alan.agile.service.TUsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/fetchUsers")
    public Result<List<fetchUsersVo>> fetchUsers(){
        List<fetchUsersVo> usersList = tUsersService.fetchUsers();
        return Result.success("请求成功",usersList);
    }
}
