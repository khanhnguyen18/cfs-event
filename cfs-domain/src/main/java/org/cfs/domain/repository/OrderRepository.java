package org.cfs.domain.repository;

import org.cfs.domain.entity.Order;

public interface OrderRepository {
    void makeOrder(Order order);
}
