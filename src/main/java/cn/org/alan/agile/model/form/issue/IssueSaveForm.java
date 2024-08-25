package cn.org.alan.agile.model.form.issue;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 2:17 PM
 */
@Data
public class IssueSaveForm {
    /**
     * 主键
     */
    private Long id;

    /**
     * 问题名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 优先级
     */
    private String priority;
}
