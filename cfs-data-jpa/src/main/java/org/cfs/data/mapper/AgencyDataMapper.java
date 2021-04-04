package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.AgencyEntity;
import org.cfs.domain.entity.Agency;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface AgencyDataMapper {
    AgencyEntity map(Agency agency);
    Agency map(AgencyEntity agency);
}
