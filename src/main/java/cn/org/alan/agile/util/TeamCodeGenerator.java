package cn.org.alan.agile.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * @Author Alan
 * @Version
 * @Date 2024/3/28 1:53 PM
 */
@Component
public class TeamCodeGenerator {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 生成班级口令
     * @param length
     * @return
     */
    public String createTeamCode(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder tokenBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            tokenBuilder.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return tokenBuilder.toString();
    }
}