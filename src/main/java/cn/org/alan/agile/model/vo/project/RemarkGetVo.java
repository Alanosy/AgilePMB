package cn.org.alan.agile.model.vo.project;

import lombok.Data;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 9:47 PM
 */
@Data
public class RemarkGetVo {
    /**
     * 备注文档
     */
    private String content;
    /**
     * 创建备注人
     */
    private String userName;
}
