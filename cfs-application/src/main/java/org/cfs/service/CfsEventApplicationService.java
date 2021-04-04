package org.cfs.service;

import lombok.AllArgsConstructor;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.repository.CfsEventRepository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class CfsEventApplicationService {

    CfsEventRepository cfsEventRepository;

    public CfsEvent create(CfsEvent cfsEvent) {
        return cfsEventRepository.create(cfsEvent);
    }

    public List<CfsEvent> search(LocalDateTime eventTimeFrom, LocalDateTime eventTimeTo, Pageable pageable) {
        return cfsEventRepository.search(eventTimeFrom, eventTimeTo, pageable);
    }


}
