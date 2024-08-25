package cn.org.alan.agile.model.form.requirement;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 1:59 PM
 */
@Data
public class ReqSaveForm {
    /**
     * 主键
     */
    private Long id;

    /**
     * 需求名称
     */
    private String name;

    /**
     * 需求文档
     */
    private String content;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 计划时间
     */
    private Date plantime;

    /**
     * 创建时间
     */
    private Date createtime;


}
