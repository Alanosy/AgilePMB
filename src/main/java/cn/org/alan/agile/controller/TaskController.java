package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import cn.org.alan.agile.model.form.task.TaskUpdateForm;
import cn.org.alan.agile.service.TTasksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:32 PM
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Resource
    private TTasksService tTasksService;

    /**
     * 添加任务
     *
     * @param taskSaveForm
     * @return
     */
    @PostMapping
    public Result<String> saveTask(@RequestBody TaskSaveForm taskSaveForm) {
        Result result = tTasksService.saveTask(taskSaveForm);
        return result;
    }

    /**
     * 分页查询任务列表
     *
     * @param pageNum
     * @param pageSize
     * @param itemId
     * @param type
     * @return
     */
    @GetMapping
    public Result<String> getTask(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "itemId", required = false) Integer itemId,
                                  @RequestParam(value = "type", required = false) String type) {
        Result result = tTasksService.getTask(pageNum, pageSize, type, itemId);
        return result;
    }

    /**
     * 删除任务
     *
     * @param taskId
     * @return
     */
    @DeleteMapping("/{taskId}")
    public Result delTask(@PathVariable("taskId") Long taskId) {
        return tTasksService.delTask(taskId);
    }

    /**
     * 修改任务
     *
     * @return
     */
    @PutMapping("/{taskId}")
    public Result updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskUpdateForm taskUpdateForm) {
        Result result = tTasksService.updateTask(taskId, taskUpdateForm);
        return result;
    }

    /**
     * 获取当前周的任务
     *
     * @return
     */
    @GetMapping("/weekTask")
    public Result<String> getWeekTask() {
        Result result = tTasksService.getWeekTask();
        return result;
    }

    /**
     * 获取任务面板
     *
     * @return
     */
    @GetMapping("/taskBoard")
    public Result getTaskBoard() {
        Result result = tTasksService.getTaskBoard();
        return result;
    }

    /**
     * 获取遗留任务
     *
     * @return
     */
    @GetMapping("/legacy-task")
    public Result<String> getLegacyTask() {
        Result result = tTasksService.getLegacyTask();
        return result;
    }

    /**
     * 获取燃尽图数据
     *
     * @param itemId
     * @return
     */
    @GetMapping("/burndown-chart")
    public Result getBurndownChart(@RequestParam(value = "itemId", required = false) Long itemId) {
        return tTasksService.getBurndownChart(itemId);
    }


}
