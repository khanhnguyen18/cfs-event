package org.cfs.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.repository.UserJpaRepository;
import org.cfs.data.mapper.UserDataMapper;
import org.cfs.domain.entity.User;
import org.cfs.domain.repository.UserRepository;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserRepositoryAdapter implements UserRepository {

    UserJpaRepository userJpaRepository;
    UserDataMapper mapper;

    @Override
    public User findByUsername(String username) {
        return mapper.map(userJpaRepository.findByUsername(username));
    }
}
