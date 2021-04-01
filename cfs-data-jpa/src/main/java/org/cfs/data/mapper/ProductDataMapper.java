package org.cfs.data.mapper;

import org.cfs.data.jpa.entity.CfsEventEntity;
import org.cfs.domain.entity.Product;
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
public interface ProductDataMapper {

    @Mapping(target = "price", source = "source.latestPrice.amount")
    Product map(CfsEventEntity source);

    List<Product> mapList(List<CfsEventEntity> sources);
}
