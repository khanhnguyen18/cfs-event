package org.cfs.domain.repository;

import org.cfs.domain.entity.CfsEvent;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CfsEventRepository {
    CfsEvent create(CfsEvent cfsEvent);

    List<CfsEvent> searchByEventTime(LocalDateTime eventTimeFrom,
                                     LocalDateTime eventTimeTo,
                                     UUID agencyId,
                                     Pageable pageable);

    List<CfsEvent> searchByResponderCode(String responderCode, UUID agencyId);
}
