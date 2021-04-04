package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgencyJpaRepository extends JpaRepository<AgencyEntity, UUID> {
    AgencyEntity getById(UUID id);
}
