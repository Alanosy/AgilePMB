package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.dashboard.DashboardGetCountForm;
import cn.org.alan.agile.service.TDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/21 10:38 PM
 */
@RestController
@RequestMapping("/api/dshboard")
public class DashboardController {

    @Resource
    private TDashboardService tDashboardService;

    /**
     * 获取项目数、待办需求数、待办任务数、待办问题数
     *
     * @return
     */
    @GetMapping("count")
    public Result getCount() {
        return tDashboardService.getCount();
    }
}
