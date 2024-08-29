package cn.org.alan.agile.model.vo.task;

import lombok.Data;

import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/28 11:20 PM
 */
@Data
public class BurndownChartGetVo
{
    /**
     * 日期列表
     */
    private List dateList;
    /**
     * 日期对应值列表
     */
    private List valueList;
}
