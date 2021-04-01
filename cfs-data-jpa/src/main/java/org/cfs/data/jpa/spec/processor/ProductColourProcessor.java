package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.ProductEntity;
import org.cfs.domain.vo.Colour;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.data.jpa.domain.Specification;

public class ProductColourProcessor implements ProductCriteriaProcessor {

    @Override
    public boolean needBuild(ProductCriteria productCriteria) {
        return productCriteria.getColour() != Colour.UNKNOWN;
    }

    @Override
    public Specification<ProductEntity> build(ProductCriteria productCriteria) {
        return (root, query, criteriaBuilder)
                        -> criteriaBuilder.or(criteriaBuilder.equal(root.get("colour"), productCriteria.getColour()));
    }
}
