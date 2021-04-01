package org.cfs.data.config;

import org.cfs.data.adapter.OrderRepositoryAdapter;
import org.cfs.data.adapter.ProductRepositoryAdapter;
import org.cfs.data.jpa.entity.ProductEntity;
import org.cfs.data.jpa.repository.OrderJpaRepository;
import org.cfs.data.jpa.repository.ProductJpaRepository;
import org.cfs.data.jpa.spec.ProductSpecificationBuilder;
import org.cfs.data.jpa.spec.processor.ProductColourProcessor;
import org.cfs.data.jpa.spec.processor.ProductCriteriaProcessor;
import org.cfs.data.jpa.spec.processor.ProductNameProcessor;
import org.cfs.data.mapper.OrderDataMapper;
import org.cfs.data.mapper.ProductDataMapper;
import org.cfs.domain.repository.OrderRepository;
import org.cfs.domain.repository.ProductRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration
@EntityScan(basePackageClasses = ProductEntity.class)
@EnableJpaRepositories(basePackageClasses = ProductJpaRepository.class)
public class DataJpaConfiguration {

    @Bean
    public ProductRepository productRepositoryAdapter(ProductJpaRepository productJpaRepository,
                                                      ProductDataMapper mapper,
                                                      ProductSpecificationBuilder productSpecificationBuilder) {
        return new ProductRepositoryAdapter(productJpaRepository, mapper, productSpecificationBuilder);
    }

    @Bean
    ProductSpecificationBuilder productSpecificationBuilder(List<ProductCriteriaProcessor> productCriteriaProcessors) {
        return new ProductSpecificationBuilder(productCriteriaProcessors);
    }

    @Bean
    ProductCriteriaProcessor productNameProcessor() {
        return new ProductNameProcessor();
    }

    @Bean
    ProductColourProcessor productColourProcessor() {
        return new ProductColourProcessor();
    }

    @Bean
    public OrderRepository orderRepositoryAdapter(OrderJpaRepository orderJpaRepository,
                                                  OrderDataMapper mapper) {
        return new OrderRepositoryAdapter(orderJpaRepository, mapper);
    }

}
