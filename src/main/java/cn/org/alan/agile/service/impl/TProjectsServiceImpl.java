package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.service.TProjectsService;
import cn.org.alan.agile.mapper.TProjectsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    public Result<IPage<ProjectPageVo>> getItemPage(Integer pageNum, Integer pageSize, String itemName) {
        IPage page = new Page(pageNum, pageSize);
        LambdaQueryWrapper<TProjects> tProjectsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        IPage iPage = tProjectsMapper.selectPage(page,tProjectsLambdaQueryWrapper);
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

        int insert = tProjectsMapper.insert(tProjects);
        return Result.success("保存成功",insert);
    }
}




