package org.cfs.dto;

import lombok.Getter;
import lombok.Setter;
import org.cfs.domain.vo.Colour;

@Getter
@Setter
public class UpdatePriceDTO {
    Long productId;
    double price;
}
