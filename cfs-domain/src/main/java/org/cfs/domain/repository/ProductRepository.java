package org.cfs.domain.repository;

import org.cfs.domain.entity.Product;
import org.cfs.domain.vo.ProductCriteria;

import java.util.List;

public interface ProductRepository {
    List<Product> search(ProductCriteria productCriteria);
    void updatePrice(Long productId, double price);
    Product getDetail(Long id);
}
