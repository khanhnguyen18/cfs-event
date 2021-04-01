package org.cfs.service;

import lombok.AllArgsConstructor;
import org.cfs.domain.entity.Order;
import org.cfs.domain.entity.Product;
import org.cfs.domain.repository.OrderRepository;
import org.cfs.domain.repository.ProductRepository;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class OrderApplicationService {

    OrderRepository orderRepository;

    public void makeOrder(Order order) {
        orderRepository.makeOrder(order);
    }

}
