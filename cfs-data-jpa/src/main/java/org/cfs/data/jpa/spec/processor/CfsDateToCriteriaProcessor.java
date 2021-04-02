package org.cfs.data.jpa.spec.processor;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.vo.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface CfsDateToCriteriaProcessor {
    boolean needBuild(SearchCriteria productCriteria);

    Specification<CfsEventEntity> build(SearchCriteria productCriteria);
}
