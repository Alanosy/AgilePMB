package cn.org.alan.agile.model.form.issue;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/29 7:29 AM
 */
@Data
public class UpdateIssueForm {

    private Long id;
    /**
     * 状态
     */
    private String state;

}
