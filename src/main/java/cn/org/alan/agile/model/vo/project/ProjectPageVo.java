package cn.org.alan.agile.model.vo.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 4:14 PM
 */
@Data
public class ProjectPageVo
{
    /**
     * 主键
     */
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目状态
     */
    private String state;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 需求数
     */
    private Integer reqcount;

    /**
     * 任务数
     */
    private Integer taskcount;

    /**
     * 问题数
     */
    private Integer issuecount;

    /**
     * 负责人
     */
    private String username;
}
