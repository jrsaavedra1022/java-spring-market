package com.jsaavedra.market.domain.repository;

import com.jsaavedra.market.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDTO {

    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);

}
