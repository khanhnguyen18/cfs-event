package org.cfs.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    Long id;
    List<OrderDetailDTO> orderDetails;
}
