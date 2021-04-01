package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.vo.ProductCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ProductNameProcessor implements ProductCriteriaProcessor {

    @Override
    public boolean needBuild(ProductCriteria productCriteria) {
        return !isBlank(productCriteria.getName());
    }

    @Override
    public Specification<CfsEventEntity> build(ProductCriteria productCriteria) {
        return (root, query, criteriaBuilder) -> {
            Path<String> childPath = root.get("name");
            Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(childPath), String.format("%%%s%%", productCriteria.getName().toLowerCase()));
            return criteriaBuilder.or(predicate);
        };
    }
}
