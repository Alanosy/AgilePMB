package cn.org.alan.agile.model.form.team;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/24 5:19 PM
 */
@Data
public class CutTeamForm {
    @NotNull(message = "团队id不能为空")
    private Long teamId;
}
