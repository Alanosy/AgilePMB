package cn.org.alan.agile.model.form.project;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Alan
 * @Version
 * @Date 2024/9/27 3:00 PM
 */
@Data
public class ItemCloseForm {
    @NotNull(message = "项目ID不能为空")
    private Long itemId;
}
