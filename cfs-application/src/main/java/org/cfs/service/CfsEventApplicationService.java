package org.cfs.service;

import lombok.AllArgsConstructor;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.repository.CfsEventRepository;
import org.cfs.domain.vo.SearchCriteria;

import java.util.List;

@AllArgsConstructor
public class CfsEventApplicationService {

    CfsEventRepository cfsEventRepository;

    public List<CfsEvent> search(SearchCriteria searchCriteria) {
        return cfsEventRepository.search(searchCriteria);
    }


}
