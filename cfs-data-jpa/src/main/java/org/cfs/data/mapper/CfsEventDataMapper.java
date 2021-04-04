package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.entity.CfsEvent;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS,
        imports = {ResponderDataMapper.class, AgencyDataMapper.class}
)
public interface CfsEventDataMapper {

    CfsEvent map(CfsEventEntity source);
    CfsEventEntity map(CfsEvent source);
    List<CfsEvent> mapList(List<CfsEventEntity> sources);
}
