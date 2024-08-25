package cn.org.alan.agile.model.vo.issue;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/20 11:28 AM
 */
@Data
public class IssuesGetVo {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 问题名称
     */
    private String issueName;

    /**
     * 问题名称
     */
    private String itemName;

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
     * 状态
     */
    private String state;

    /**
     * 负责人名称
     */
    private String principalName;

    /**
     * 文档内容
     */
    private String content;

    /**
     * 负责人id
     */
    private Long principalid;

    /**
     * 文档内容
     */
    private String createName;

    /**
     * 文档内容
     */
    private String updateTime;




}
