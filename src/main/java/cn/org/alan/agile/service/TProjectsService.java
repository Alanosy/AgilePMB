package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.form.project.ItemContentUpdateForm;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.form.project.ProjectUpdateForm;
import cn.org.alan.agile.model.form.project.RemarkSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.model.vo.project.fetchProjectsVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author alan
* @description 针对表【T_Projects】的数据库操作Service
* @createDate 2024-07-03 07:59:50
*/
public interface TProjectsService extends IService<TProjects> {

    Result<IPage<ProjectPageVo>> getItemPage(Integer pageNum, Integer pageSize, String itemName, Integer type);

    Result saveItem(ProjectSaveForm projectSaveForm);

    List<fetchProjectsVo> fetchProjects();

    Result getOverviewItem(Long itemId);

    Result getItemContent(Long itemId);

    Result updateItemContent(ItemContentUpdateForm itemContentUpdateForm);

    Result saveRemark(RemarkSaveForm remarkSaveForm);

    Result getRemark(Long itemId);

    Result<String> uploadFile(MultipartFile file, Long itemId) throws IOException;

    Result getFileList(Long itemId);

    Result updateProject(ProjectUpdateForm projectUpdateForm);
}
