package cn.org.alan.agile.model.vo.team;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 11:01 PM
 */
@Data
public class TeamGetVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 团队名称
     */
    private String name;

    /**
     * 团队代码
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 状态
     */
    private String state;
}
