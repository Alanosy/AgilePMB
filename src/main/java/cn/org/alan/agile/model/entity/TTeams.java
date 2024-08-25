package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName T_Teams
 */
@TableName(value ="T_Teams")
@Data
public class TTeams implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 团队名称
     */
    private String name;

    /**
     * 团队代码
     */
    private String code;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}