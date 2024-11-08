package cn.org.alan.agile.model.form.project;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 9:34 PM
 */
@Data
public class RemarkSaveForm {
    @NotNull(message = "项目id不能为空")
    private Long itemId;
    private String content;
}
