package cn.org.alan.agile.model.vo.dashboard;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/22 11:59 PM
 */
@Data
public class DashBoardCountVo {
    /**
     * 项目总数
     */
    private Integer projectCount;
    /**
     * 待办任务数
     */
    private Integer taskCount;
    /**
     * 待办需求数
     */
    private Integer requirementCount;
    /**
     * 待办问题数
     */
    private Integer issueCount;
}
