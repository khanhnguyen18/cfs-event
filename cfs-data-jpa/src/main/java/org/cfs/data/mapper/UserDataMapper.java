package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.UserEntity;
import org.cfs.domain.entity.User;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS
)
public interface UserDataMapper {

    User map(UserEntity source);
}
