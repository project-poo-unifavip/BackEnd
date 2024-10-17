package com.estoque.estoquejava.repository;

import com.estoque.estoquejava.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByProductCode(String productCode);
}
