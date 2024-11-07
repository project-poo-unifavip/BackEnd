package com.estoque.estoquejava.controllers;

import com.estoque.estoquejava.dto.ProductsDTO;
import com.estoque.estoquejava.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class RegisterController {

    @Autowired
    private ProductsService productsService;

    // Endpoint para adicionar um novo produto
    @PostMapping
    public ResponseEntity<ProductsDTO> addProduct(@RequestBody ProductsDTO productsDTO) {
        ProductsDTO createdProduct = productsService.addProduct(productsDTO);
        return ResponseEntity.ok(createdProduct);
    }

    // Endpoint para buscar todos os produtos
    @GetMapping("/all")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        List<ProductsDTO> products = productsService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 caso não haja produtos
        }
        return ResponseEntity.ok(products); // Retorna 200 com a lista de produtos
    }

    // Endpoint para buscar um produto pelo código
    @GetMapping("/{productCode}")
    public ResponseEntity<ProductsDTO> getProductByCode(@PathVariable String productCode) {
        return productsService.findProductByCode(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
