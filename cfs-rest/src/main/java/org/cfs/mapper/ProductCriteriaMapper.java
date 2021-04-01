package org.cfs.mapper;

import org.cfs.domain.vo.Colour;
import org.cfs.domain.vo.ProductCriteria;
import org.cfs.dto.ProductCriteriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = SET_TO_NULL,
        nullValueCheckStrategy = ALWAYS,
        imports = {Colour.class}
)
public interface ProductCriteriaMapper {

    @Mapping(target = "colour", expression = "java(Colour.from(source.getColour()))")
    ProductCriteria map(ProductCriteriaDTO source);
}
