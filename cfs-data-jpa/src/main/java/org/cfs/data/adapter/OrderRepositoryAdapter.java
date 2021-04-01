package org.cfs.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.entity.OrderDetailEntity;
import org.cfs.data.jpa.entity.OrderEntity;
import org.cfs.data.jpa.repository.OrderJpaRepository;
import org.cfs.data.mapper.OrderDataMapper;
import org.cfs.domain.entity.Order;
import org.cfs.domain.repository.OrderRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderRepositoryAdapter implements OrderRepository {

    OrderJpaRepository orderJpaRepository;
    OrderDataMapper mapper;


    @Override
    public void makeOrder(Order order) {
        OrderEntity orderEntity = mapper.map(order);
        orderEntity.setDateTime(LocalDateTime.now());

        for (OrderDetailEntity detail : orderEntity.getOrderDetails()) {
            detail.setOrder(orderEntity);
        }
        orderJpaRepository.save(orderEntity);
    }
}
