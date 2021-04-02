package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.vo.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class CfsDateFromProcessor implements CfsDateToCriteriaProcessor {

    @Override
    public boolean needBuild(SearchCriteria productCriteria) {
        return productCriteria.getDateFrom() != null;
    }

    @Override
    public Specification<CfsEventEntity> build(SearchCriteria productCriteria) {
        return (root, query, criteriaBuilder) -> {
            Path<String> childPath = root.get("name");
            Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(childPath), String.format("%%%s%%",
                    productCriteria.getDateFrom()));
            return criteriaBuilder.or(predicate);
        };
    }
}
