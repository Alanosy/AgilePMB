package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TProjects;
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
}




