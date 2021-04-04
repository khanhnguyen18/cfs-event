package org.cfs.mapper;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.dto.CfsEventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface CfsEventDTOMapper {

    @Mapping(source = "agency.id", target = "agencyId")
    @Mapping(source = "responder.code", target = "responder")
    CfsEventDTO map(CfsEvent cfsEvent);

    @Mapping(source = "agencyId", target = "agency.id")
    @Mapping(source = "responder", target = "responder.code")
    CfsEvent map(CfsEventDTO cfsEvent);

    List<CfsEventDTO> map(List<CfsEvent> cfsEvents);
}
