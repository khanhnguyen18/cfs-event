package org.cfs.security.service;

import org.cfs.domain.repository.UserRepository;
import org.cfs.security.vo.CfsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.cfs.domain.entity.User user = userRepository.findByUsername(username);
        if (user != null) {
            return new CfsUser(user.getUsername(), user.getPassword(), new ArrayList<>(), user.getAgency().getId());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
