package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName T_Tasks
 */
@TableName(value ="T_Tasks")
@Data
public class TTasks implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务名称
     */
    private String name;

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
    @TableField(fill = FieldFill.INSERT)
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

    @TableLogic
    private Integer deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 关联项目id
     */
    private Long itemid;
    /**
     * 团队id
     */
    private Long teamid;

}