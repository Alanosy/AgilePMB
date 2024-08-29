package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TTasksConverter;
import cn.org.alan.agile.mapper.TProjectsMapper;
import cn.org.alan.agile.mapper.TTasksMapper;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.model.form.task.TaskSaveForm;
import cn.org.alan.agile.model.vo.task.*;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTaskIssue;
import cn.org.alan.agile.service.TTaskIssueService;
import cn.org.alan.agile.mapper.TTaskIssueMapper;
import org.springframework.stereotype.Service;

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
 * @description 针对表【T_Task_Issue】的数据库操作Service实现
 * @createDate 2024-07-03 07:59:51
 */
@Service
public class TTaskIssueServiceImpl extends ServiceImpl<TTaskIssueMapper, TTaskIssue>
        implements TTaskIssueService {


    @Resource
    private TTasksMapper tTasksMapper;
    @Resource
    private TTasksConverter tTasksConverter;
    @Resource
    private TProjectsMapper tProjectsMapper;

    @Override
    public Result saveTask(TaskSaveForm taskSaveForm) {

        TTasks tTasks = new TTasks();
        tTasks.setContent(taskSaveForm.getContent());
        tTasks.setUserid(SecurityUtil.getUserId());
        tTasks.setName(taskSaveForm.getName());
        tTasks.setPrincipalid(taskSaveForm.getPrincipalId());
        tTasks.setStarttime(taskSaveForm.getStartDate());
        tTasks.setEndtime(taskSaveForm.getEndDate());
        tTasks.setState(taskSaveForm.getState());
        tTasks.setItemid(taskSaveForm.getItemId());
        int insert = tTasksMapper.insert(tTasks);
        if (insert > 0) {
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result getTask(Integer pageNum, Integer pageSize, String type, Integer itemId) {
        // 创建Page对象
        Page<TTasks> page = new Page<>(pageNum, pageSize);
        Page<TaskGetVo> tTasksPage = tTasksMapper.getTask(page, type, itemId, SecurityUtil.getUserId(), SecurityUtil.getTeamId());


        // 实体转换
        return Result.success("查询成功", tTasksPage);

    }

    @Override
    public Result<String> delTask(Long taskId) {
        LambdaQueryWrapper<TTasks> tRequirementsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tRequirementsLambdaQueryWrapper.eq(TTasks::getId, taskId);
        int deleterow = tTasksMapper.delete(tRequirementsLambdaQueryWrapper);
        if (deleterow > 0) {
            return Result.success("删除成功");
        }
        return Result.failed("删除失败");
    }

    @Override
    public Result getWeekTask() {

        List<List<WeekTaskGetVo>> weekTaskGetVos = new ArrayList<>();
        List<LocalDate> datesOfThisWeek = getDatesOfThisWeek();
        for (LocalDate date : datesOfThisWeek) {
            List<WeekTaskGetVo> result = tTasksMapper.getWeekTask(date, SecurityUtil.getUserId(), SecurityUtil.getTeamId());
            weekTaskGetVos.add(result);
        }
        return Result.success("请求成功", weekTaskGetVos);
    }

    @Override
    public Result getTaskBoard() {

        List<List<TaskBoardGetVo>> taskResult = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<TaskBoardGetVo> result = tTasksMapper.getTaskBoard(i, SecurityUtil.getUserId(), SecurityUtil.getTeamId());
            taskResult.add(result);
        }
        return Result.success("请求成功", taskResult);
    }

    @Override
    public Result getLegacyTask() {
        List<LegacyTaskGetVo> result = tTasksMapper.getLegacyTask(SecurityUtil.getUserId(), SecurityUtil.getTeamId());
        return Result.success("请求成功", result);
    }

    @Override
    public Result getBurndownChart(Long itemId) {
        LambdaQueryWrapper<TProjects> tProjectsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tProjectsLambdaQueryWrapper.eq(TProjects::getId, itemId);
        TProjects tProjects = tProjectsMapper.selectOne(tProjectsLambdaQueryWrapper);
        Date startdate = tProjects.getStartdate();
        Date enddate = tProjects.getEnddate();
        List<Date> dates = getDatesBetween(startdate, enddate);
        Date currentdate = new Date(); // 当前日期
        Integer taskCount = tTasksMapper.getTaskCount(itemId);
        // 确保当前时间大于开始时间且小于结束时间
        List<String> dateList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        BurndownChartGetVo burndownChartGetVo = new BurndownChartGetVo();
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy/MM/dd");
        if (currentdate.after(startdate) && currentdate.before(tProjects.getEnddate())) {
            long daysPassed = getDaysBetweenDates(startdate, currentdate);
            // 输出每一天的日期
            for (int i = 0; i <= daysPassed; i++) {
                Integer BurndownValue = taskCount;
                for (int j = 0; j <= i; j++) {
                    Integer finishTaskCount = tTasksMapper.getBurndownChart(itemId, dates.get(j));
                    BurndownValue = BurndownValue - finishTaskCount;
                }
                String formattedDateStr = targetFormat.format(dates.get(i));
                dateList.add(formattedDateStr);
                valueList.add(BurndownValue);
            }
            burndownChartGetVo.setDateList(dateList);
            burndownChartGetVo.setValueList(valueList);
            return Result.success("请求成功",burndownChartGetVo);
        }
        return Result.failed("当前项目，未开始或已结束");
    }

    public static long getDaysBetweenDates(Date startdate, Date currentdate) {
        long diffInMillies = Math.abs(currentdate.getTime() - startdate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static List<Date> getDatesBetween(Date startdate, Date enddate) {
        List<Date> datesList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startdate);

        while (calendar.getTime().before(enddate) || calendar.getTime().equals(enddate)) {
            Date result = calendar.getTime();
            datesList.add(result);
            calendar.add(Calendar.DATE, 1);
        }

        return datesList;
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




