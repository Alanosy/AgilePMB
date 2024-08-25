package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.mapper.TDashboardMapper;
import cn.org.alan.agile.model.form.dashboard.DashboardGetCountForm;
import cn.org.alan.agile.model.vo.dashboard.DashBoardCountVo;
import cn.org.alan.agile.service.TDashboardService;
import cn.org.alan.agile.util.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/22 11:53 PM
 */
@Service
public class TDashboardServiceImpl implements TDashboardService {
    @Resource
    private TDashboardMapper tDashboardMapper;
    @Override
    public Result getCount() {
        DashBoardCountVo result = tDashboardMapper.getCount( SecurityUtil.getUserId(),SecurityUtil.getTeamId());
        return Result.success("请求成功",result);
    }
}
