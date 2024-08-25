package cn.org.alan.agile.util;

import cn.org.alan.agile.security.SysUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * @Author Alan
 * @Version 1.0
 * @Date 2024/3/30 0:10
 */
@Slf4j
public class SecurityUtil {

    private SecurityUtil(){}

    /**
     * 获取当前用户id
     * @return 用户id
     */
    public static Long getUserId(){
        SysUserDetails user = (SysUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return user.getUser().getId();
    }

    /**
     * 获取团队id
     * @return
     */
    public static Long getTeamId(){
        SysUserDetails user = (SysUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return user.getTeamId();
    }


    /**
     * 获取当前用户角色
     * @return 角色
     */
    public static String getRole(){
        SysUserDetails user = (SysUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return user.getRole();
    }


}
