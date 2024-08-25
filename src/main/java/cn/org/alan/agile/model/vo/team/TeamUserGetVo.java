package cn.org.alan.agile.model.vo.team;

import lombok.Data;

import java.util.Date;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 11:12 PM
 */
@Data
public class TeamUserGetVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 团队名称
     */
    private String realname;

    /**
     * 团队代码
     */
    private String createtime;

    /**
     * 创建时间
     */
    private Integer role;
}
