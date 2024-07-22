package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.issue.IssueSaveForm;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import cn.org.alan.agile.service.TIssuesService;
import cn.org.alan.agile.service.TTaskIssueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:32 PM
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Resource
    private TTaskIssueService tTaskIssueService;
    @PostMapping
    public Result<String> saveTask(@RequestBody TaskSaveForm taskSaveForm){
        Result  result = tTaskIssueService.saveTask(taskSaveForm);
        return result;
    }
}
