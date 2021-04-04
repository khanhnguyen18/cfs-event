package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CfsEventJpaRepository extends PagingAndSortingRepository<CfsEventEntity, Long> {
    Page<CfsEventEntity> findByEventTimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo, Pageable pageable);
}
