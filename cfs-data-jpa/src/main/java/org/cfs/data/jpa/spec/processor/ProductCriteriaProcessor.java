package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface ProductCriteriaProcessor {
    boolean needBuild(ProductCriteria productCriteria);

    Specification<CfsEventEntity> build(ProductCriteria productCriteria);
}
