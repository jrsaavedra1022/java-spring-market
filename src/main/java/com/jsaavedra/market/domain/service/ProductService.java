package com.jsaavedra.market.domain.service;

import com.jsaavedra.market.domain.ProductDTO;
import com.jsaavedra.market.domain.repository.ProductRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryDTO productRepositoryDTO;

    public List<ProductDTO> getAll(){
        return productRepositoryDTO.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId){
        return productRepositoryDTO.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        return  productRepositoryDTO.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO product){
        return  productRepositoryDTO.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepositoryDTO.delete(productId);
            return true;
        }).orElse(false);
    }


}
