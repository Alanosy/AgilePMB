package cn.org.alan.agile.model.form.task;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 2:24 PM
 */
@Data
public class TaskSaveForm {
    /**
     * 主键
     */

    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务文档
     */
    private String content;

    /**
     * 计划时间
     */
    private Date plantime;

    /**
     * 类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 评估时间
     */
    private String evaluation;

    /**
     * 创建人
     */
    private Long userid;



}
