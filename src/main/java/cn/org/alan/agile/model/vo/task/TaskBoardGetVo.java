package cn.org.alan.agile.model.vo.task;

import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 3:26 PM
 */
@Data
public class TaskBoardGetVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务文档
     */
    private String content;

    /**
     * 类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 创建时间
     */
    private Date starttime;
    /**
     * 创建时间
     */
    private Date endtime;
    /**
     * 创建时间
     */
    private Date updatetime;
    /**
     * 创建时间
     */
    private Date finishtime;

    /**
     * 创建时间
     */
    private String  state;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 评估时间
     */
    private String evaluation;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 创建人
     */
    private Long principalid;
    /**
     * 关联项目id
     */
    private Long itemid;
    /**
     * 团队id
     */
    private Long teamid;
    /**
     * 负责人名称
     */
    private String pName;
}
