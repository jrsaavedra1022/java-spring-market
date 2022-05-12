package com.jsaavedra.market.persistence;

import com.jsaavedra.market.domain.ProductDTO;
import com.jsaavedra.market.domain.repository.ProductRepositoryDTO;
import com.jsaavedra.market.persistence.crud.ProductCrudRepository;
import com.jsaavedra.market.persistence.entity.Product;
import com.jsaavedra.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryDTO {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        List<Product> products = (List<Product>) productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarceProducts(int stock){
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndState(stock, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    public Optional<ProductDTO> getProduct(int productId){
        return productCrudRepository.findById(productId).map(prod -> mapper.toProductDTO(prod));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product product_w = mapper.toProduct(product);
        return mapper.toProductDTO(productCrudRepository.save(product_w));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }

}
