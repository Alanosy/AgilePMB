package cn.org.alan.agile.model.form.team;

import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "团队代码不能为空")
    private String tcode;

    /**
     * 用户id
     */
    private Long userId;
}
