package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.form.project.ItemCloseForm;
import cn.org.alan.agile.model.vo.project.ItemContentGetVo;
import cn.org.alan.agile.model.vo.project.OverviewItemGetVo;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.model.vo.project.fetchProjectsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author alan
 * @description 针对表【T_Projects】的数据库操作Mapper
 * @createDate 2024-07-03 07:59:50
 * @Entity cn.org.alan.exam.model/entity.TProjects
 */
public interface TProjectsMapper extends BaseMapper<TProjects> {

    IPage<ProjectPageVo> selectProject(IPage<ProjectPageVo> page, String itemName, Long teamId, Integer type, Long userId);

    List<fetchProjectsVo> fetchProjects(Long teamId);

    OverviewItemGetVo getOverviewItem(Long itemId);

    ItemContentGetVo getItemContent(Long itemId);

    Integer closeItem(ItemCloseForm itemCloseForm);

    // 删除 T_Projects 表中的数据
    void deleteProjectById(Long itemId);

    // 删除 T_Issues 表中的数据
    void deleteIssuesByItemId(Long itemId);

    // 删除 T_Remarks 表中的数据
    void deleteRemarksByItemId(Long itemId);

    // 删除 T_Requirements 表中的数据
    void deleteRequirementsByItemId(Long itemId);

    // 删除 T_Task 表中的数据
    void deleteTaskByItemId(Long itemId);
}




