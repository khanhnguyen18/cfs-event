package org.cfs.data.jpa.repository;

import org.cfs.data.jpa.entity.ResponderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponderJpaRepository extends JpaRepository<ResponderEntity, Long> {
    ResponderEntity getByCode(String code);
}
