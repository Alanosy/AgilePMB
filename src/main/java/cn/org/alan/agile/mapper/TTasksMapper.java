package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.model.vo.task.TaskGetVo;
import cn.org.alan.agile.model.vo.task.WeekTaskGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDate;
import java.util.List;

/**
* @author alan
* @description 针对表【T_Tasks】的数据库操作Mapper
* @createDate 2024-07-03 07:59:51
* @Entity cn.org.alan.exam.model/entity.TTasks
*/
public interface TTasksMapper extends BaseMapper<TTasks> {

    Page<TaskGetVo> getTask(Page<TTasks> page, String type, Integer itemId, Long userId, Long teamId);

    List<WeekTaskGetVo> getWeekTask(LocalDate date);

    // List<String> getWeekTask();
}



