package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TFiles;
import cn.org.alan.agile.model.entity.TIssues;
import cn.org.alan.agile.model.form.project.ProjectUpdateForm;
import cn.org.alan.agile.model.vo.project.FileListGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 10:54 PM
 */
public interface TFilesMapper extends BaseMapper<TFiles> {
    List<FileListGetVo> getFileList(Long itemId);

    Integer updateProject(ProjectUpdateForm projectUpdateForm);
}
