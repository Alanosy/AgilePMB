package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.mapper.TUserTeamMapper;
import cn.org.alan.agile.model.entity.TUserTeam;
import cn.org.alan.agile.model.form.team.CutTeamForm;
import cn.org.alan.agile.model.form.team.TeamAddForm;
import cn.org.alan.agile.model.form.team.TeamSaveForm;
import cn.org.alan.agile.model.vo.team.TeamGetVo;
import cn.org.alan.agile.model.vo.team.TeamUserGetVo;
import cn.org.alan.agile.util.SecurityUtil;
import cn.org.alan.agile.util.TeamCodeGenerator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTeams;
import cn.org.alan.agile.service.TTeamsService;
import cn.org.alan.agile.mapper.TTeamsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author alan
* @description 针对表【T_Teams】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TTeamsServiceImpl extends ServiceImpl<TTeamsMapper, TTeams>
    implements TTeamsService{

    @Resource
    private TeamCodeGenerator teamCodeGenerator;
    @Resource
    private TTeamsMapper tTeamsMapper;
    @Resource
    private TUserTeamMapper tUserTeamMapper;
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
    public Result getTeamPage(Integer pageNum, Integer pageSize, String teamName) {
        Page<TTeams> page = new Page<>(pageNum, pageSize);

        Page<TeamGetVo> result = tUserTeamMapper.getTeamPage(page, teamName,SecurityUtil.getUserId());

        return Result.success("查询成功", result);
    }

    @Override
    public Result getTeamUserPage(Integer pageNum, Integer pageSize, String realName) {
        Page<TTeams> page = new Page<>(pageNum, pageSize);

        Page<TeamUserGetVo> result = tUserTeamMapper.getTeamUserPage(page,SecurityUtil.getTeamId(),realName);

        return Result.success("查询成功", result);
    }

    @Override
    public Result cutTeam(CutTeamForm cutTeamForm) {
        Integer result = tUserTeamMapper.cutTeam(cutTeamForm,SecurityUtil.getTeamId(),SecurityUtil.getUserId());
        return null;
    }
}




