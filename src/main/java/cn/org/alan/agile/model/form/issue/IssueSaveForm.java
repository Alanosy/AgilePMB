package cn.org.alan.agile.model.form.issue;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 2:17 PM
 */
@Data
public class IssueSaveForm {

    /**
     * 问题名称
     */
    @NotBlank(message = "标题不能为空")
    private String name;

    /**
     * 负责人
     */
    private Long principalId;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String state;

    /**
     * 问题内容
     */
    private String content;


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

    /**
     * 优先级
     */
    private String priority;
}
