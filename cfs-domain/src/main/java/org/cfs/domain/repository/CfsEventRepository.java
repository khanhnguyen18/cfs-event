package org.cfs.domain.repository;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.entity.Responder;
import org.cfs.domain.vo.SearchCriteria;

import java.util.List;

public interface CfsEventRepository {
    CfsEvent create(CfsEvent cfsEvent);
    List<CfsEvent> search(SearchCriteria productCriteria);
}
