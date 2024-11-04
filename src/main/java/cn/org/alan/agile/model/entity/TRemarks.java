package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 9:40 PM
 */
@TableName(value ="T_Remarks")
@Data
public class TRemarks {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;



    /**
     * 项目文档
     */
    private String content;

    private Long itemid;
    private Long userid;

    /**
     * 创建时间
     */
    private Date createtime;
}
