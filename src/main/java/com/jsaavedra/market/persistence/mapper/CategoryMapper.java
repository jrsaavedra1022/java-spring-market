package com.jsaavedra.market.persistence.mapper;

import com.jsaavedra.market.domain.CategoryDTO;
import com.jsaavedra.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active"),
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDTO category);

}
