package org.cfs.data.jpa.spec;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.spec.processor.ProductCriteriaProcessor;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSpecificationBuilder {

    List<ProductCriteriaProcessor> productCriteriaProcessors;

    public Specification<CfsEventEntity> build(ProductCriteria productCriteria) {
        Specification<CfsEventEntity> result = null;
        for (ProductCriteriaProcessor productCriteriaProcessor : productCriteriaProcessors) {
            if (productCriteriaProcessor.needBuild(productCriteria)) {
                Specification<CfsEventEntity> specification = productCriteriaProcessor.build(productCriteria);
                if (result == null) {
                    result = specification;
                } else {
                    result = result.and(specification);
                }
            }
        }
        return result;
    }
}
