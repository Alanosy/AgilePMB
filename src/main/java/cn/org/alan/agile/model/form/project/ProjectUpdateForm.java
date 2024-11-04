package cn.org.alan.agile.model.form.project;

import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/28 9:32 AM
 */
@Data
public class ProjectUpdateForm {

    /**
     * 主键
     */
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目文档
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 项目结束日期
     */
    private Date enddate;
    /**
     * 项目开始时间
     */
    private Date startdate;

    /**
     * 项目状态
     */
    private String state;

    /**
     * 创建人
     */
    private Long userid;

}
