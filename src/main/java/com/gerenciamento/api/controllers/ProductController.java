package com.gerenciamento.api.controllers;

import com.gerenciamento.api.dto.ProductDTO;
import com.gerenciamento.api.dto.ProductProjection;
import com.gerenciamento.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity <List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }


    @GetMapping("/greater/{valor}")
    public ResponseEntity <List<ProductDTO>> getAllProductsGreaterThan(@PathVariable Integer valor){
        return ResponseEntity.ok(productService.getProductsGreaterThan(valor));
    }
    @GetMapping("/less")
    public ResponseEntity <List<ProductDTO>> asdf(@RequestParam(required = true) Integer valor){
        return ResponseEntity.ok(productService.getProductsLessThan(valor));
    }
    @GetMapping("/names")
    public ResponseEntity <List<ProductProjection>> getAllProductsNames(){
        return ResponseEntity.ok(productService.getProductsNames());
    }


    @PostMapping
    public ResponseEntity<ProductDTO> registerProduct(@RequestBody @Valid ProductDTO data){
        return ResponseEntity.ok(productService.save(data));
    }

    @PutMapping
    public ResponseEntity<ProductDTO>  updateProduct(@RequestBody @Valid ProductDTO data){
                return ResponseEntity.ok(productService.update(data));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
