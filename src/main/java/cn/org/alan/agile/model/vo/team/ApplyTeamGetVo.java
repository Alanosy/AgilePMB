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
    private String realName;
    private String username;
    private LocalDateTime createtime;
    private Long teamId;
}
