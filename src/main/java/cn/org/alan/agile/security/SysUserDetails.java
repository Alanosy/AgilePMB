package cn.org.alan.agile.security;


import cn.org.alan.agile.model.entity.TUsers;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/6/9 11:03 PM
 */
@Data
@NoArgsConstructor
public class SysUserDetails implements UserDetails {
    private List<SimpleGrantedAuthority> permissions;
    private TUsers user;
    private String username;
    private Long teamId;
    private String role;

    public SysUserDetails(TUsers user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }

    public void setPermissions(List<SimpleGrantedAuthority> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String getPassword() {
        String myPassword=user.getPassword();
        user.setPassword("");
        return myPassword;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
