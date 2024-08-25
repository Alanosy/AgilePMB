package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName T_Requirements
 */
@TableName(value ="T_Requirements")
@Data
public class TRequirements implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 需求名称
     */
    private String name;

    /**
     * 需求文档
     */
    private String content;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 计划开始时间
     */
    private Date starttime;

    /**
     * 计划开始时间
     */
    private Date endtime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 关联项目id
     */
    private Long itemid;

    /**
     * 负责人id
     */
    private Long principalid;

    @TableLogic
    private Integer deleteFlag;
    /**
     * 所属团队id
     */
    private Long teamid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 状态
     */
    private String state;

}