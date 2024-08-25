package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TIssues;
import cn.org.alan.agile.model.vo.issue.IssuesGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author alan
* @description 针对表【T_Issues】的数据库操作Mapper
* @createDate 2024-07-03 07:59:50
* @Entity cn.org.alan.exam.model/entity.TIssues
*/
public interface TIssuesMapper extends BaseMapper<TIssues> {

    Page<IssuesGetVo> getIssue(Page<TIssues> page, Integer itemId, String issueType, String type, Long userId, Long teamId);
}




