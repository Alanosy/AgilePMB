package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TTeams;
import cn.org.alan.agile.model.entity.TUserTeam;
import cn.org.alan.agile.model.form.team.CutTeamForm;
import cn.org.alan.agile.model.vo.team.TeamGetVo;
import cn.org.alan.agile.model.vo.team.TeamUserGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author alan
* @description 针对表【T_User_Team】的数据库操作Mapper
* @createDate 2024-07-03 07:59:51
* @Entity cn.org.alan.exam.model/entity.TUserTeam
*/
public interface TUserTeamMapper extends BaseMapper<TUserTeam> {

    Page<TeamGetVo> getTeamPage(Page<TTeams> page, String teamName, Long userId);

    Page<TeamUserGetVo> getTeamUserPage(Page<TTeams> page, Long teamId, String realName);

    Integer cutTeam(CutTeamForm cutTeamForm, Long teamId, Long userId);
}




