package org.cfs.security.service;

import org.cfs.security.vo.CfsUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {

    public CfsUser getCurrentUser() {
        return (CfsUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
