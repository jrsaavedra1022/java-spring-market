package com.jsaavedra.market.persistence.mapper;

import com.jsaavedra.market.domain.PurchaseDTO;
import com.jsaavedra.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {

    @Mappings({
            @Mapping( source = "products", target = "items")
    })
    PurchaseDTO toPurchaseDTO(Purchase purchase);
    List<PurchaseDTO> toPurchaseDTO(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "client", ignore = true)
    })
    Purchase toPurchase(PurchaseDTO purchase);
}
