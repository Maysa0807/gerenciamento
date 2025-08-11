package com.gerenciamento.api.repository;

import com.gerenciamento.api.dto.ProductProjection;
import com.gerenciamento.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

   List<Product> findAllByActiveTrue();

   @Query("SELECT product from com.eventos.api.entity.Product product where product.active = :active")
   List<Product> encontrarProdutosAtivosOuNao(Boolean active);
   

   @Query(value = "SELECT * from product p where p.active = :active ", nativeQuery = true)
   List<Product> encontrarAtivos(Boolean active);
   

   @Query(value = "SELECT p.name, p.price_in_cents as priceInCents  from product p where p.active = :active ", nativeQuery = true)
   List<ProductProjection> findActivesProjection(Boolean active);
   List<Product> findByPriceInCentsGreaterThanEqual(Integer price);


   @Query("""
       SELECT product from com.eventos.api.entity.Product product where product.priceInCents <= :price
       """)
   List<Product> findProductsLess(Integer price);
}
