package cn.org.alan.agile.model.form.team;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 4:51 PM
 */
@Data
public class TeamSaveForm {
    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 用户id
     */
    private Long userId;
}
