package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.ResponderEntity;
import org.cfs.domain.entity.Responder;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS,
        imports = {AgencyDataMapper.class}
)
public interface ResponderDataMapper {

    Responder map(ResponderEntity source);
}
