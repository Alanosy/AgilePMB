package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName T_Users
 */
@TableName(value ="T_Users")
@Data
public class TUsers implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 账户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;
    /**
     * 头像
     */
    private String avater;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}