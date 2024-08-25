package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName T_User_Team
 */
@TableName(value ="T_User_Team")
@Data
public class TUserTeam implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 团队表ID
     */
    private Long tid;

    /**
     * 用户表ID
     */
    private Long uid;

    @TableField(fill = FieldFill.INSERT)
    private Date createtime;
    /**
     * 是否是当前团队
     */
    private String  state;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}