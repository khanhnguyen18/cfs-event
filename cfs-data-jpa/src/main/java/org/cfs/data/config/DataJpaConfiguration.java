package org.cfs.data.config;

import org.cfs.data.adapter.CfsEventRepositoryAdapter;
import org.cfs.data.adapter.UserRepositoryAdapter;
import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.repository.AgencyJpaRepository;
import org.cfs.data.jpa.repository.CfsEventJpaRepository;
import org.cfs.data.jpa.repository.ResponderJpaRepository;
import org.cfs.data.jpa.repository.UserJpaRepository;
import org.cfs.data.mapper.CfsEventDataMapper;
import org.cfs.data.mapper.UserDataMapper;
import org.cfs.domain.repository.CfsEventRepository;
import org.cfs.domain.repository.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = CfsEventEntity.class)
@EnableJpaRepositories(basePackageClasses = CfsEventJpaRepository.class)
public class DataJpaConfiguration {

    @Bean
    public CfsEventRepository cfsEventRepository(CfsEventJpaRepository cfsEventJpaRepository,
                                                 AgencyJpaRepository agencyJpaRepository,
                                                 ResponderJpaRepository responderJpaRepository,
                                                 CfsEventDataMapper mapper) {
        return new CfsEventRepositoryAdapter(cfsEventJpaRepository, agencyJpaRepository, responderJpaRepository, mapper);
    }

    @Bean
    public UserRepository userRepository(UserJpaRepository userJpaRepository,
                                         UserDataMapper mapper) {
        return new UserRepositoryAdapter(userJpaRepository, mapper);
    }
}
