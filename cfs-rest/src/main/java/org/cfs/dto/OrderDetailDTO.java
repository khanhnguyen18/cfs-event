package org.cfs.dto;


import lombok.Getter;
import lombok.Setter;
import org.cfs.domain.vo.Status;

@Getter
@Setter
public class OrderDetailDTO {
    Long id;

    int quantity;

    Status status;

    ProductDTO product;

    OrderDTO order;
}
