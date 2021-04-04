package org.cfs.data.config;

import org.cfs.data.adapter.CfsEventRepositoryAdapter;
import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.repository.AgencyJpaRepository;
import org.cfs.data.jpa.repository.CfsEventJpaRepository;
import org.cfs.data.jpa.repository.ResponderJpaRepository;
import org.cfs.data.mapper.CfsEventDataMapper;
import org.cfs.domain.repository.CfsEventRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = CfsEventEntity.class)
@EnableJpaRepositories(basePackageClasses = CfsEventJpaRepository.class)
public class DataJpaConfiguration {

    @Bean
    public CfsEventRepository cfsEventRepositoryAdapter(CfsEventJpaRepository cfsEventJpaRepository,
                                                        AgencyJpaRepository agencyJpaRepository,
                                                        ResponderJpaRepository responderJpaRepository,
                                                        CfsEventDataMapper mapper) {
        return new CfsEventRepositoryAdapter(cfsEventJpaRepository, agencyJpaRepository, responderJpaRepository, mapper);
    }

}
