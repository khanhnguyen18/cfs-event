package org.cfs.mapper;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.dto.CfsEventDTO;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface CfsEventDTOMapper {
    CfsEventDTO map(CfsEvent cfsEvent);

    List<CfsEventDTO> map(List<CfsEvent> cfsEvents);
}
