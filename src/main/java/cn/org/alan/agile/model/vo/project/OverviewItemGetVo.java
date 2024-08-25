package cn.org.alan.agile.model.vo.project;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 8:27 PM
 */
@Data
public class OverviewItemGetVo {
    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 创建人
     */
    private String userName;

    /**
     * 项目状态
     */
    private Integer state;

    /**
     * 需求数
     */
    private Integer reqNum;

    /**
     * 需求完成数
     */
    private Integer reqfNum;

    /**
     * 需求进度百分比
     */
    private Integer reqPercent;

    /**
     * 问题数
     */
    private Integer issueNum;

    /**
     * 问题完成数
     */
    private Integer issuefNum;

    /**
     * 问题进度百分比
     */
    private Integer issuePercent;

    /**
     * 任务数
     */
    private Integer taskNum;

    /**
     * 任务完成数
     */
    private Integer taskfNum;


    /**
     * 任务进度百分比
     */
    private Integer taskPercent;

}
