package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductJpaRepository extends JpaRepository<CfsEventEntity, Long>, JpaSpecificationExecutor<CfsEventEntity> {
    CfsEventEntity getById(Long id);
}
