package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.vo.dashboard.DashBoardCountVo;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/22 11:54 PM
 */
public interface TDashboardMapper {
    DashBoardCountVo getCount(Long userId, Long teamId);
}
