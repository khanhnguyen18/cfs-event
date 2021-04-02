package org.cfs.data.config;

import org.cfs.data.adapter.CfsEventRepositoryAdapter;
import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.repository.CfsEventJpaRepository;
import org.cfs.data.jpa.spec.CfsEventSpecificationBuilder;
import org.cfs.data.jpa.spec.processor.CfsDateFromProcessor;
import org.cfs.data.jpa.spec.processor.CfsDateToCriteriaProcessor;
import org.cfs.data.mapper.CfsEventDataMapper;
import org.cfs.domain.repository.CfsEventRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration
@EntityScan(basePackageClasses = CfsEventEntity.class)
@EnableJpaRepositories(basePackageClasses = CfsEventJpaRepository.class)
public class DataJpaConfiguration {

    @Bean
    public CfsEventRepository cfsEventRepositoryAdapter(CfsEventJpaRepository productJpaRepository,
                                                        CfsEventDataMapper mapper,
                                                        CfsEventSpecificationBuilder productSpecificationBuilder) {
        return new CfsEventRepositoryAdapter(productJpaRepository, mapper, productSpecificationBuilder);
    }

    @Bean
    CfsEventSpecificationBuilder productSpecificationBuilder(List<CfsDateToCriteriaProcessor> productCriteriaProcessors) {
        return new CfsEventSpecificationBuilder(productCriteriaProcessors);
    }

    @Bean
    CfsDateToCriteriaProcessor productNameProcessor() {
        return new CfsDateFromProcessor();
    }

}
