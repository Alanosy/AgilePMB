package cn.org.alan.agile.model.form.project;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 9:21 PM
 */
@Data
public class ItemContentUpdateForm {
    /**
     * 项目id
     */
    @NotNull(message = "项目id不能为空")
    private Long itemId;
    /**
     * 文档内容
     */
    private String content;
}
