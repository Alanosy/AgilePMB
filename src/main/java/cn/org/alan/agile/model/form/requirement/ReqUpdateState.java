package cn.org.alan.agile.model.form.requirement;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/21 5:43 PM
 */
@Data
public class ReqUpdateState {
    /**
     * 需求id
     */
    private Long Id;

    /**
     * 状态
     */
    private String state;
}
