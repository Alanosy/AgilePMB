package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName T_Issues
 */
@TableName(value = "T_Issues")
@Data
public class TIssues implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 计划开始时间
     */
    private Date startdate;

    /**
     * 计划开始时间
     */
    private Date enddate;
    /**
     * 创建人id
     */
    private Long userid;
    /**
     * 问题名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 关联项目id
     */
    private Long itemid;

    /**
     * 状态
     */
    private String state;

    /**
     * 负责人id
     */
    private Long principalid;

    @TableLogic
    private Integer deleteFlag;
    /**
     * 团队id
     */
    private Long teamid;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}