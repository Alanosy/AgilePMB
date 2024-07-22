package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author alan
* @description 针对表【T_Projects】的数据库操作Service
* @createDate 2024-07-03 07:59:50
*/
public interface TProjectsService extends IService<TProjects> {



    Result<IPage<ProjectPageVo>> getItemPage(Integer pageNum, Integer pageSize, String itemName);

    Result saveItem(ProjectSaveForm projectSaveForm);
}
