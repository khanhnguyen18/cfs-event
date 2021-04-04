package org.cfs.domain.repository;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.vo.SearchCriteria;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface CfsEventRepository {
    CfsEvent create(CfsEvent cfsEvent);

    List<CfsEvent> search(LocalDateTime eventTimeFrom, LocalDateTime eventTimeTo, Pageable pageable);
}
