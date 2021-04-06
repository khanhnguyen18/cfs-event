package org.cfs.service;

import lombok.AllArgsConstructor;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.repository.CfsEventRepository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class CfsEventApplicationService {

    CfsEventRepository cfsEventRepository;

    public CfsEvent create(CfsEvent cfsEvent, UUID agencyIdOfUser) {
        if (!cfsEvent.getAgency().getId().equals(agencyIdOfUser)){
            throw new RuntimeException("Not allow to create user in another agency");
        }

        return cfsEventRepository.create(cfsEvent);
    }

    public List<CfsEvent> searchByEventTime(LocalDateTime eventTimeFrom,
                                            LocalDateTime eventTimeTo,
                                            UUID agencyId,
                                            Pageable pageable) {
        return cfsEventRepository.searchByEventTime(eventTimeFrom, eventTimeTo, agencyId, pageable);
    }

    public List<CfsEvent> searchByResponderCode(String responderCode, UUID agencyId) {
        return cfsEventRepository.searchByResponderCode(responderCode, agencyId);
    }

}
