package org.cfs.config;

import org.cfs.domain.repository.OrderRepository;
import org.cfs.domain.repository.ProductRepository;
import org.cfs.service.OrderApplicationService;
import org.cfs.service.ProductApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    ProductApplicationService productApplicationService(ProductRepository productRepository) {
        return new ProductApplicationService(productRepository);
    }

    @Bean
    OrderApplicationService orderApplicationService(OrderRepository orderRepository) {
        return new OrderApplicationService(orderRepository);
    }
}
