package org.cfs.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.repository.AgencyJpaRepository;
import org.cfs.data.jpa.repository.CfsEventJpaRepository;
import org.cfs.data.jpa.repository.ResponderJpaRepository;
import org.cfs.data.mapper.CfsEventDataMapper;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.repository.CfsEventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CfsEventRepositoryAdapter implements CfsEventRepository {

    CfsEventJpaRepository cfsEventJpaRepository;
    AgencyJpaRepository agencyJpaRepository;
    ResponderJpaRepository responderJpaRepository;
    CfsEventDataMapper mapper;

    @Override
    public CfsEvent create(CfsEvent cfsEvent) {
        CfsEventEntity entity = mapper.map(cfsEvent);
        entity.setAgency(agencyJpaRepository.getById(cfsEvent.getAgency().getId()));
        entity.setResponder(responderJpaRepository.getByCode(cfsEvent.getResponder().getCode()));
        return mapper.map(cfsEventJpaRepository.save(entity));
    }

    @Override
    public List<CfsEvent> search(LocalDateTime eventTimeFrom, LocalDateTime eventTimeTo, Pageable pageable) {
        Page<CfsEventEntity> eventEntityPage = cfsEventJpaRepository.findByEventTimeBetween(eventTimeFrom, eventTimeTo, pageable);
        return mapper.mapList(eventEntityPage.getContent());
    }


}
