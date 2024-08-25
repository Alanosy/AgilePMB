package cn.org.alan.agile.model.form.team;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 6:05 PM
 */
@Data
public class TeamAddForm {
    /**
     * 团队代码
     */
    private String tcode;

    /**
     * 用户id
     */
    private Long userId;
}
