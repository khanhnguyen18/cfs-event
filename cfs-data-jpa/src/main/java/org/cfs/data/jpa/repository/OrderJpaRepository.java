package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<AgencyEntity, Long> {
}
