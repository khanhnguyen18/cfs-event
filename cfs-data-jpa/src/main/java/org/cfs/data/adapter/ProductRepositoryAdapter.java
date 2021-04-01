package org.cfs.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.entity.PriceEntity;
import org.cfs.data.jpa.entity.ProductEntity;
import org.cfs.data.jpa.repository.ProductJpaRepository;
import org.cfs.data.jpa.spec.ProductSpecificationBuilder;
import org.cfs.data.mapper.ProductDataMapper;
import org.cfs.domain.entity.Product;
import org.cfs.domain.repository.ProductRepository;
import org.cfs.domain.vo.ProductCriteria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductRepositoryAdapter implements ProductRepository {

    ProductJpaRepository productJpaRepository;
    ProductDataMapper mapper;
    ProductSpecificationBuilder productSpecificationBuilder;

    @Override
    public Product getDetail(Long id) {
        return mapper.map(productJpaRepository.getById(id));
    }


    @Override
    public void updatePrice(Long productId, double price) {
        ProductEntity product = productJpaRepository.getById(productId);
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setAmount(price);
        priceEntity.setProduct(product);
        priceEntity.setDate(LocalDateTime.now());
        product.getPrices().add(priceEntity);
        productJpaRepository.save(product);
    }

    @Override
    public List<Product> search(ProductCriteria productCriteria) {
        return mapper.mapList(
                productJpaRepository.findAll(productSpecificationBuilder.build(productCriteria))
        );
    }


}
