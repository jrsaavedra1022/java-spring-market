package com.jsaavedra.market.domain.repository;

import com.jsaavedra.market.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryDTO {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getScarceProducts(int quantity);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);
}
