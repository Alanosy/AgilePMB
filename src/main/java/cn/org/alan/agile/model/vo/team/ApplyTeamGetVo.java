package cn.org.alan.agile.model.vo.team;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/26 10:40 PM
 */
@Data
public class ApplyTeamGetVo {
    private Long id;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 账号
     */
    private String username;
    /**
     * 创建时间
     */
    private LocalDateTime createtime;
    /**
     * 申请加入的团队id
     */
    private Long teamId;
}
