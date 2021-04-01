package org.cfs.service;

import lombok.AllArgsConstructor;
import org.cfs.domain.entity.Product;
import org.cfs.domain.repository.ProductRepository;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class ProductApplicationService {

    ProductRepository productRepository;

    public List<Product> search(ProductCriteria productCriteria) {
        return productRepository.search(productCriteria);
    }

    @Transactional
    public void updatePrice(Long productId, double price) {
        productRepository.updatePrice(productId, price);
    }

    public Product getDetail(Long id) {
        return productRepository.getDetail(id);
    }

}
