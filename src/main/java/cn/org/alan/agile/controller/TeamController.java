package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.team.CutTeamForm;
import cn.org.alan.agile.model.form.team.TeamAddForm;
import cn.org.alan.agile.model.form.team.TeamSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.service.TTeamsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:32 PM
 */
@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Resource
    private TTeamsService tTeamsService;

    /**
     * 创建团队
     * @param teamSaveForm
     * @return
     */
    @PostMapping
    public Result saveTeam(@RequestBody TeamSaveForm teamSaveForm){
        return tTeamsService.saveTeam(teamSaveForm);
    }

    /**
     * 加入团队
     * @return
     */
    @PostMapping("/addTeam")
    public Result addTeam(@RequestBody TeamAddForm teamAddForm){
        return tTeamsService.addTeam(teamAddForm);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param teamName
     * @return
     */
    @GetMapping
    public Result getTeamPage(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                                    @RequestParam(value = "teamName",required = false) String teamName){
        Result itemPage = tTeamsService.getTeamPage(pageNum,pageSize,teamName);
        return itemPage;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/user")
    public Result getTeamUserPage(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "realName",required = false) String realName){
        Result itemPage = tTeamsService.getTeamUserPage(pageNum,pageSize,realName);
        return itemPage;
    }

    /**
     * 切换团队
     * @param cutTeamForm
     * @return
     */
    @PutMapping("/cut")
    public Result cutTeam(@RequestBody CutTeamForm cutTeamForm){
        Result result = tTeamsService.cutTeam(cutTeamForm);
        return result;
    }
}
