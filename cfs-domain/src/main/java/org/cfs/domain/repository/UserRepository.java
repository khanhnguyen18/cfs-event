package org.cfs.domain.repository;

import org.cfs.domain.entity.User;

public interface UserRepository {
    User findByUsername(String username);
}
