package com.jsaavedra.market.persistence.mapper;

import com.jsaavedra.market.domain.ProductDTO;
import com.jsaavedra.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "state", target = "active"),
    })
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDTO product);

}
