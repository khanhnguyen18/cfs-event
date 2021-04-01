package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.UserEntity;
import org.cfs.data.jpa.entity.AgencyEntity;
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
    AgencyEntity map(Order order);
    UserEntity mapOrderDetail(OrderDetail orderDetail);
    List<UserEntity> mapOrderDetailEntityList (List<OrderDetail> orderDetail);
}
