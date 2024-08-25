package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.model.vo.project.fetchProjectsVo;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.service.TProjectsService;
import cn.org.alan.agile.mapper.TProjectsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author alan
* @description 针对表【T_Projects】的数据库操作Service实现
* @createDate 2024-07-03 07:59:50
*/
@Service
public class TProjectsServiceImpl extends ServiceImpl<TProjectsMapper, TProjects>
    implements TProjectsService{
    @Resource
    private TProjectsMapper tProjectsMapper;

    @Override
    public Result<IPage<ProjectPageVo>> getItemPage(Integer pageNum, Integer pageSize, String itemName, Integer type) {
        IPage<ProjectPageVo> page = new Page(pageNum, pageSize);
        IPage<ProjectPageVo> iPage = tProjectsMapper.selectProject(page,itemName, SecurityUtil.getTeamId(),type,SecurityUtil.getUserId());
        return Result.success("查询成功",iPage);
    }

    @Override
    public Result saveItem(ProjectSaveForm projectSaveForm) {
        TProjects tProjects = new TProjects();
        tProjects.setName(projectSaveForm.getName());
        tProjects.setEnddate(projectSaveForm.getEnddate());
        tProjects.setStartdate(projectSaveForm.getStartdate());
        tProjects.setState(projectSaveForm.getState());
        tProjects.setUserid(projectSaveForm.getUserid());
        tProjects.setTeamid(SecurityUtil.getTeamId());
        int insert = tProjectsMapper.insert(tProjects);
        return Result.success("保存成功",insert);
    }

    @Override
    public List<fetchProjectsVo> fetchProjects() {
        List<fetchProjectsVo> projectsVoList = tProjectsMapper.fetchProjects();
        return projectsVoList;
    }
}




