package cn.org.alan.agile.model.vo.task;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/20 12:49 PM
 */
@Data
public class TaskGetVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 任务名称
     */
    private String taskName;
    private String createName;

    /**
     * 状态
     */
    private String state;

    /**
     * 负责人名字
     */
    private String principalName;

    /**
     * 开始时间
     */
    private Date finishtime;

    /**
     * 结束时间
     */
    private Date endtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 更新时间
     */
    private Date createtime;
    /**
     * 文档内容
     */
    private String content;
    private Long principalid;


}

