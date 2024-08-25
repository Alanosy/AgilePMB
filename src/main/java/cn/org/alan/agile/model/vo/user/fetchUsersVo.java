package cn.org.alan.agile.model.vo.user;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/15 10:46 PM
 */
@Data
public class fetchUsersVo {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名称
     */
    private String name;
}
