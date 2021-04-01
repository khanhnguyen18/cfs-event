package org.cfs.domain.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.cfs.domain.vo.Status;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
public class OrderDetail {
    Long id;

    int quantity;

    Status status;

    Product product;

    Order order;
}
