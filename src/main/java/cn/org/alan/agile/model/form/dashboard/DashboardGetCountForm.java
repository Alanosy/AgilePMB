package cn.org.alan.agile.model.form.dashboard;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/22 11:57 PM
 */
@Data
public class DashboardGetCountForm {
    @NotNull(message = "团队ID不能为空")
    private Long teamId;
}
