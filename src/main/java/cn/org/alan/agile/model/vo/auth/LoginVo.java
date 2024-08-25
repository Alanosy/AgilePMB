package cn.org.alan.agile.model.vo.auth;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 10:03 PM
 */
@Data
public class LoginVo {
    /**
     * 主键
     */
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
     * 团队id
     */
    private Long teamId;

    /**
     * 角色
     */
    private String role;
    /**
     * 头像
     */
    private String avater;
}
