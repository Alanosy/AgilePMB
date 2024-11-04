package cn.org.alan.agile.model.form.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/15 1:29 PM
 */
@Data
public class ProjectSaveForm
{
    /**
     * 主键
     */
    private Long id;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
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

    private static final long serialVersionUID = 1L;

}
