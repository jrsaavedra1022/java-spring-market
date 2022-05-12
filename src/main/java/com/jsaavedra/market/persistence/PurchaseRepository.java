package com.jsaavedra.market.persistence;

import com.jsaavedra.market.domain.PurchaseDTO;
import com.jsaavedra.market.domain.repository.PurchaseRepositoryDTO;
import com.jsaavedra.market.persistence.crud.PurchaseCrudRepository;
import com.jsaavedra.market.persistence.entity.Purchase;
import com.jsaavedra.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseRepositoryDTO {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchaseDTO((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> mapper.toPurchaseDTO(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchase) {
        Purchase purchase_w = mapper.toPurchase(purchase);
        purchase_w.getProducts().forEach(product -> product.setPurchase(purchase_w));

        return mapper.toPurchaseDTO(purchaseCrudRepository.save(purchase_w));
    }
}
