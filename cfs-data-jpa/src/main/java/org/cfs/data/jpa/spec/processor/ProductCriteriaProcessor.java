package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.ProductEntity;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface ProductCriteriaProcessor {
    boolean needBuild(ProductCriteria productCriteria);

    Specification<ProductEntity> build(ProductCriteria productCriteria);
}
