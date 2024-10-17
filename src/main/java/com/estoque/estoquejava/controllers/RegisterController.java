package com.estoque.estoquejava.controller;

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

    @PostMapping
    public ResponseEntity<ProductsDTO> addProduct(@RequestBody ProductsDTO productsDTO) {
        ProductsDTO createdProduct = productsService.addProduct(productsDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductsDTO> getProductByCode(@PathVariable String productCode) {
        return productsService.findProductByCode(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
