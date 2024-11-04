package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName T_Projects
 */
@TableName(value ="T_Projects")
@Data
public class TProjects implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    /**
     * 团队id
     */
    private Long teamid;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}