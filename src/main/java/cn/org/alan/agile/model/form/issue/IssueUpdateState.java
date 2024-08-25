package cn.org.alan.agile.model.form.issue;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/21 10:08 PM
 */
@Data
public class IssueUpdateState {
    /**
     * 需求id
     */
    private Long Id;

    /**
     * 状态
     */
    private String state;
}
