package org.cfs.rest;

import lombok.AllArgsConstructor;
import org.cfs.dto.OrderDTO;
import org.cfs.mapper.OrderDTOMapper;
import org.cfs.service.OrderApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderApplicationService orderApplicationService;
    private final OrderDTOMapper mapper;

    @PostMapping("/make-order")
    public void makeOrder(@RequestBody OrderDTO orderDTO) {
        orderApplicationService.makeOrder(mapper.map(orderDTO));
    }
}
