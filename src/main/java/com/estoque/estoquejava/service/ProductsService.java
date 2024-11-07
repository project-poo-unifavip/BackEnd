package com.estoque.estoquejava.service;

import com.estoque.estoquejava.dto.ProductsDTO;
import com.estoque.estoquejava.entity.Products;
import com.estoque.estoquejava.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    // Método para adicionar um novo produto
    public ProductsDTO addProduct(ProductsDTO productsDTO) {
        Products product = new Products(
                productsDTO.getProductCode(),
                productsDTO.getName(),
                productsDTO.getCategory(),
                productsDTO.getUnitCost(),
                productsDTO.getProfitMargin()
        );
        product = productsRepository.save(product);
        return new ProductsDTO(
                product.getId(),
                product.getProductCode(),
                product.getName(),
                product.getCategory(),
                product.getUnitCost(),
                product.getProfitMargin()
        );
    }

    // Método para buscar todos os produtos
    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(product -> new ProductsDTO(
                        product.getId(),
                        product.getProductCode(),
                        product.getName(),
                        product.getCategory(),
                        product.getUnitCost(),
                        product.getProfitMargin()))
                .collect(Collectors.toList()); // Usar Collectors.toList() para compatibilidade com versões anteriores do Java
    }

    // Método para buscar um produto pelo código
    public Optional<ProductsDTO> findProductByCode(String productCode) {
        return productsRepository.findByProductCode(productCode)
                .map(product -> new ProductsDTO(
                        product.getId(),
                        product.getProductCode(),
                        product.getName(),
                        product.getCategory(),
                        product.getUnitCost(),
                        product.getProfitMargin()
                ));
    }
}
