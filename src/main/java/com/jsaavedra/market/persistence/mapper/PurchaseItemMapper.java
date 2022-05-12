package com.jsaavedra.market.persistence.mapper;

import com.jsaavedra.market.domain.PurchaseItemDTO;
import com.jsaavedra.market.persistence.entity.PurchasesProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItemDTO toPurchaseItemDTO(PurchasesProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchasesProduct toPurchasesProduct(PurchaseItemDTO item);
}
