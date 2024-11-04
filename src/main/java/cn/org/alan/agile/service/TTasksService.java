package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TTasksConverter;
import cn.org.alan.agile.mapper.TProjectsMapper;
import cn.org.alan.agile.mapper.TTasksMapper;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import cn.org.alan.agile.model.form.task.TaskUpdateForm;
import cn.org.alan.agile.model.vo.task.*;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
* @author alan
* @description 针对表【T_Tasks】的数据库操作Service
* @createDate 2024-07-03 07:59:51
*/
public interface TTasksService extends IService<TTasks> {

    Result saveTask(TaskSaveForm taskSaveForm);

    Result getTask(Integer pageNum, Integer pageSize, String type, Integer itemId);

    Result delTask(Long taskId);

    Result updateTask(Long taskId, TaskUpdateForm taskUpdateForm);

    Result getWeekTask();

    Result getTaskBoard();

    Result getLegacyTask();

    Result getBurndownChart(Long itemId);
}
