package cn.org.alan.agile.model.vo.user;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/24 3:20 PM
 */
@Data
public class MyselfDataGetVo {
    /**
     * 用户名称
     */
    private String realName;
    /**
     * 团队名称
     */
    private String teamName;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 头像
     */
    private String avater;
}
