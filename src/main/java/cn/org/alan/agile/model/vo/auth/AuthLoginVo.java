package cn.org.alan.agile.model.vo.auth;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/27 12:18 PM
 */
@Data
public class AuthLoginVo {
    private String token;
    private Integer teamState;
}
