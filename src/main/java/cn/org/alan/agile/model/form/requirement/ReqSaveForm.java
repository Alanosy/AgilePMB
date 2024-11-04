package cn.org.alan.agile.model.form.requirement;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 1:59 PM
 */
@Data
public class ReqSaveForm {

    /**
     * 需求名称
     */
    @NotBlank(message = "需求名称不能为空")
    private String name;

    /**
     * 状态
     */
    private String state;

    /**
     * 需求文档
     */
    private String content;

    /**
     * 创建人
     */
    private Long principalId;

    /**
     * 创建人
     */
    private Long itemId;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 计划时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startDate;

    /**
     * 计划时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endDate;



}
