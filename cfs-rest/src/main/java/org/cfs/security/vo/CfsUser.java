package org.cfs.security.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
public class CfsUser extends User {
    private UUID agencyId;

    public CfsUser(String username, String password, Collection<? extends GrantedAuthority> authorities, UUID agencyId) {
        super(username, password, authorities);
        this.agencyId = agencyId;
    }

    public CfsUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
