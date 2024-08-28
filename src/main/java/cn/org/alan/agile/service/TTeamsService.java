package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TTeams;
import cn.org.alan.agile.model.form.team.ApplyCheckForm;
import cn.org.alan.agile.model.form.team.CutTeamForm;
import cn.org.alan.agile.model.form.team.TeamAddForm;
import cn.org.alan.agile.model.form.team.TeamSaveForm;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author alan
* @description 针对表【T_Teams】的数据库操作Service
* @createDate 2024-07-03 07:59:51
*/
public interface TTeamsService extends IService<TTeams> {

    Result saveTeam(TeamSaveForm teamSaveForm);

    Result addTeam(TeamAddForm teamAddForm);

    Result getTeamPage(Integer pageNum, Integer pageSize, String teamName, String type);

    Result getTeamUserPage(Integer pageNum, Integer pageSize, String realName);

    Result cutTeam(HttpServletRequest request, CutTeamForm cutTeamForm);

    Result getApplyTeamPage(Integer pageNum, Integer pageSize, String userName);

    Result applyCheck(ApplyCheckForm applyCheckForm);
}
