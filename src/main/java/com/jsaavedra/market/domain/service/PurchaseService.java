package com.jsaavedra.market.domain.service;

import com.jsaavedra.market.domain.PurchaseDTO;
import com.jsaavedra.market.domain.repository.PurchaseRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepositoryDTO purchaseRepositoryDTO;

    public List<PurchaseDTO> getAll() {
        return purchaseRepositoryDTO.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseRepositoryDTO.getByClient(clientId);
    }

    public PurchaseDTO save(PurchaseDTO purchase) {
        return purchaseRepositoryDTO.save(purchase);
    }
}
