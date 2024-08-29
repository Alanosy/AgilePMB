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
    /**
     * 文件url
     */
    private String url;
    private Long userid;
    private Long itemid;
    /**
     * 文件名
     */
    private String filename;
    private Date createtime;
}
