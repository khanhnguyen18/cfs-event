package org.cfs.rest;

import lombok.AllArgsConstructor;
import org.cfs.dto.ProductCriteriaDTO;
import org.cfs.dto.ProductDTO;
import org.cfs.dto.UpdatePriceDTO;
import org.cfs.mapper.ProductCriteriaMapper;
import org.cfs.mapper.ProductDTOMapper;
import org.cfs.service.ProductApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductApplicationService productApplicationService;
    private final ProductDTOMapper mapper;
    private final ProductCriteriaMapper productCriteriaMapper;

    @PostMapping("/search")
    public List<ProductDTO> search(@RequestBody ProductCriteriaDTO productCriteria) {
        return mapper.map(productApplicationService.search(productCriteriaMapper.map(productCriteria)));
    }

    @PutMapping("/update-price")
    public void updatePrice(@RequestBody UpdatePriceDTO updatePriceDTO) {
        productApplicationService.updatePrice(updatePriceDTO.getProductId(), updatePriceDTO.getPrice());
    }

    @GetMapping("/{id}/detail")
    public ProductDTO getById(@PathVariable("id") Long id) {
        return mapper.map(productApplicationService.getDetail(id));
    }
}
