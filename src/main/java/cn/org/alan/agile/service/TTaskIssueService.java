package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TTaskIssue;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author alan
* @description 针对表【T_Task_Issue】的数据库操作Service
* @createDate 2024-07-03 07:59:51
*/
public interface TTaskIssueService extends IService<TTaskIssue> {

    Result saveTask(TaskSaveForm taskSaveForm);

    Result getTask(Integer pageNum, Integer pageSize, String type, Integer itemId);

    Result<String> delTask(Long taskId);

    Result getWeekTask();

    Result getTaskBoard();
}
