package cn.org.alan.agile.model.vo.requirement;

import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/16 1:59 PM
 */
@Data
public class ReqGetVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 需求标题
     */
    private String reqname;

    /**
     * 所属项目
     */
    private String itemname;

    /**
     * 状态
     */
    private String state;

    /**
     * 开始时间
     */
    private Date starttime;

    /**
     * 结束时间
     */
    private Date endtime;

    /**
     * 负责人
     */
    private String realname;

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
     * 结束时间
     */
    private Date createtime;

    /**
     * 完成时间
     */
    private Date finishtime;

}
