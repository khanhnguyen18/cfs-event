package org.cfs.data.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.cfs.data.jpa.repository.CfsEventJpaRepository;
import org.cfs.data.jpa.spec.CfsEventSpecificationBuilder;
import org.cfs.data.mapper.CfsEventDataMapper;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.entity.Responder;
import org.cfs.domain.repository.CfsEventRepository;
import org.cfs.domain.vo.SearchCriteria;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CfsEventRepositoryAdapter implements CfsEventRepository {

    CfsEventJpaRepository productJpaRepository;
    CfsEventDataMapper mapper;
    CfsEventSpecificationBuilder productSpecificationBuilder;


    @Override
    public List<CfsEvent> search(SearchCriteria productCriteria) {
        return mapper.mapList(
                productJpaRepository.findAll(productSpecificationBuilder.build(productCriteria))
        );
    }


}
