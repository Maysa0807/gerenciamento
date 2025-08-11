package com.gerenciamento.api.service;

import com.gerenciamento.api.dto.ProductDTO;
import com.gerenciamento.api.dto.ProductProjection;
import com.gerenciamento.api.entity.Product;
import com.gerenciamento.api.mapper.ProductMapper;
import com.gerenciamento.api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper, ProductRepository repository) {
        this.productMapper = productMapper;
        this.repository = repository;
    }

    @Transactional
    public List<ProductDTO> getProducts(){
            return productMapper.entitiesToDtos(repository.encontrarAtivos(true));
    }
    @Transactional
    public List<ProductDTO> getProductsGreaterThan(Integer valor){
        return productMapper.entitiesToDtos(repository.findByPriceInCentsGreaterThanEqual(valor));
    }
    @Transactional
    public List<ProductDTO> getProductsLessThan(Integer valor){
        return productMapper.entitiesToDtos(repository.findProductsLess(valor));
    }
    @Transactional
    public List<ProductProjection> getProductsNames(){
        return repository.findActivesProjection(true);
    }


    @Transactional
    public ProductDTO save (ProductDTO productDto){
        Product newProduct =  productMapper.dtoToEntity(productDto);
        newProduct.setActive(true);
        return productMapper.entityToDto(repository.save(newProduct));
    }
    @Transactional
    public ProductDTO update (ProductDTO productDto){
        Product product = repository.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setPriceInCents(productDto.getPriceInCents());
        return productMapper.entityToDto(repository.save(product));
    }
    @Transactional
    public void delete (String id){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setActive(false);
    }
}
