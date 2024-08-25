package cn.org.alan.agile.model.vo.project;

import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 11:06 PM
 */
@Data
public class FileListGetVo {
    private Long id;
    private String url;
    private Long userid;
    private Long itemid;
    private String filename;
    private Date createtime;
}
