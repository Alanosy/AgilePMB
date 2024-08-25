package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 10:52 PM
 */
@TableName(value ="T_Files")
@Data
public class TFiles {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String url;
    private Long userid;
    private Long itemid;
    private String filename;
    private Date createtime;
}
