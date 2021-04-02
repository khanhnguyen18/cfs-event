package org.cfs.config;

import org.cfs.domain.repository.CfsEventRepository;
import org.cfs.service.CfsEventApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    CfsEventApplicationService cfsEventApplicationService(CfsEventRepository cfsEventRepository) {
        return new CfsEventApplicationService(cfsEventRepository);
    }

}
