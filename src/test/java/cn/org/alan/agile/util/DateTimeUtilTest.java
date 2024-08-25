package cn.org.alan.agile.util;


import cn.org.alan.agile.mapper.TTasksMapper;
import cn.org.alan.agile.model.vo.task.WeekTaskGetVo;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/5/28 11:28 PM
 */ class DateTimeUtilTest {

    @Resource
    private SecretUtils secretUtils;
    @Resource
    private TTasksMapper tTasksMapper;

    @Test
    void getDate() {
        // ArrayList<WeekTaskGetVo> weekTaskGetVos = new ArrayList<>();
        // List<LocalDate> datesOfThisWeek = getDatesOfThisWeek();
        // for (LocalDate date : datesOfThisWeek) {
        //     System.out.println(date);
        //     WeekTaskGetVo result =
        // List<String> weekTask = tTasksMapper.getWeekTask();
        // weekTaskGetVos.add(result);
        // }
        // System.out.println(weekTask);
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

    @Test
    void dateToStr() {
        System.out.println(DateTimeUtil.dateToStr(DateTimeUtil.getDate()));
    }
}