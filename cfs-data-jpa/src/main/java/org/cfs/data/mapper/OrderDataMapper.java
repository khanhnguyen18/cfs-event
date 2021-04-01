package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.OrderDetailEntity;
import org.cfs.data.jpa.entity.OrderEntity;
import org.cfs.domain.entity.Order;
import org.cfs.domain.entity.OrderDetail;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface OrderDataMapper {
    OrderEntity map(Order order);
    OrderDetailEntity mapOrderDetail(OrderDetail orderDetail);
    List<OrderDetailEntity> mapOrderDetailEntityList (List<OrderDetail> orderDetail);
}
