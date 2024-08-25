package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TTasksConverter;
import cn.org.alan.agile.mapper.TTasksMapper;
import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import cn.org.alan.agile.model.vo.task.TaskGetVo;
import cn.org.alan.agile.model.vo.task.WeekTaskGetVo;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTaskIssue;
import cn.org.alan.agile.service.TTaskIssueService;
import cn.org.alan.agile.mapper.TTaskIssueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
* @author alan
* @description 针对表【T_Task_Issue】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TTaskIssueServiceImpl extends ServiceImpl<TTaskIssueMapper, TTaskIssue>
    implements TTaskIssueService{


    @Resource
    private TTasksMapper tTasksMapper;
    @Resource
    private TTasksConverter tTasksConverter;

    @Override
    public Result saveTask(TaskSaveForm taskSaveForm) {

        TTasks tTasks = new TTasks();
        tTasks.setContent(taskSaveForm.getContent());
        tTasks.setName(taskSaveForm.getName());
        tTasks.setPriority(taskSaveForm.getPriority());
        tTasks.setType(taskSaveForm.getType());
        tTasks.setUserid(1L);
        tTasks.setTeamid(SecurityUtil.getTeamId());
        int insert = tTasksMapper.insert(tTasks);
        if(insert>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result getTask(Integer pageNum, Integer pageSize, String type, Integer itemId) {
        // 创建Page对象
        Page<TTasks> page = new Page<>(pageNum, pageSize);
        Page<TaskGetVo> tTasksPage = tTasksMapper.getTask(page, type,itemId, SecurityUtil.getUserId(),SecurityUtil.getTeamId());


        // 实体转换
        return Result.success("查询成功", tTasksPage);

    }

    @Override
    public Result<String> delTask(Long taskId) {
        LambdaQueryWrapper<TTasks> tRequirementsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tRequirementsLambdaQueryWrapper.eq(TTasks::getId,taskId);
        int deleterow = tTasksMapper.delete(tRequirementsLambdaQueryWrapper);
        if(deleterow>0){
            return Result.success("删除成功");
        }
        return Result.failed("删除失败");
    }

    @Override
    public Result getWeekTask() {

        List<List<WeekTaskGetVo>> weekTaskGetVos = new ArrayList<>();
        List<LocalDate> datesOfThisWeek = getDatesOfThisWeek();
        for (LocalDate date : datesOfThisWeek) {
            List<WeekTaskGetVo> result = tTasksMapper.getWeekTask(date);
            weekTaskGetVos.add(result);
        }
        return Result.success("请求成功",weekTaskGetVos);
    }




    private static List<LocalDate> getDatesOfThisWeek() {
        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();

        // Calculate the start of the week (Monday)
        LocalDate weekStart = now.minusDays(dayOfWeekValue - 1);
        List<LocalDate> datesOfThisWeek = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalDate date = weekStart.plusDays(i);
            datesOfThisWeek.add(date);
        }

        return datesOfThisWeek;
    }
}




