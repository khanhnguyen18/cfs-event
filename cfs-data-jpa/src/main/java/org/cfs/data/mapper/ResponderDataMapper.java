package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.data.jpa.entity.ResponderEntity;
import org.cfs.domain.entity.Responder;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface ResponderDataMapper {

    Responder map(ResponderEntity source);
}
