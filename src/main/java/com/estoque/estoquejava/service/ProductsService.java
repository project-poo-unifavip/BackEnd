package com.estoque.estoquejava.service;

import com.estoque.estoquejava.dto.ProductsDTO;
import com.estoque.estoquejava.entity.Products;
import com.estoque.estoquejava.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public ProductsDTO addProduct(ProductsDTO productsDTO) {
        Products product = new Products(
                productsDTO.getProductCode(),
                productsDTO.getName(),  // Nome do produto
                productsDTO.getCategory(),  // Categoria do produto
                productsDTO.getUnitCost(),
                productsDTO.getProfitMargin()
        );
        product = productsRepository.save(product);
        return new ProductsDTO(
                product.getId(),
                product.getProductCode(),
                product.getName(),  // Retornando nome
                product.getCategory(),  // Retornando categoria
                product.getUnitCost(),
                product.getProfitMargin()
        );
    }

    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(product -> new ProductsDTO(
                        product.getId(),
                        product.getProductCode(),
                        product.getName(),  // Incluindo nome
                        product.getCategory(),  // Incluindo categoria
                        product.getUnitCost(),
                        product.getProfitMargin()))
                .toList();
    }

    public Optional<ProductsDTO> findProductByCode(String productCode) {
        return productsRepository.findByProductCode(productCode)
                .map(product -> new ProductsDTO(
                        product.getId(),
                        product.getProductCode(),
                        product.getName(),  // Incluindo nome
                        product.getCategory(),  // Incluindo categoria
                        product.getUnitCost(),
                        product.getProfitMargin()
                ));
    }
}
