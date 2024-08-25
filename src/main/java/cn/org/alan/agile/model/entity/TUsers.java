package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableId
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
    private Date createtime;
    /**
     * 头像
     */
    private String avater;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}