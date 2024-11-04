package cn.org.alan.agile.model.form.task;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 2:24 PM
 */
@Data
public class TaskSaveForm {

    /**
     * 任务名称
     */
    @NotBlank(message = "任务名称不能为空")
    private String name;

    /**
     * 任务文档
     */
    private String content;

    /**
     * 类型
     */
    private String state;

    /**
     * 创建时间
     */
    private Date startDate;
    /**
     * 创建时间
     */
    private Date endDate;





    /**
     * 创建人
     */
    private Long principalId;

    /**
     * 创建人
     */
    private Long itemId;



}
