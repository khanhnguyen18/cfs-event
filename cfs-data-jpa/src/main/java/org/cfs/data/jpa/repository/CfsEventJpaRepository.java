package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CfsEventJpaRepository extends PagingAndSortingRepository<CfsEventEntity, Long> {
    Page<CfsEventEntity> findByEventTimeBetweenAndAgencyId(LocalDateTime dateFrom,
                                                           LocalDateTime dateTo,
                                                           UUID agencyId,
                                                           Pageable pageable);
    List<CfsEventEntity> findByResponderCodeAndAgencyId(String responderCode, UUID agencyId);
}
