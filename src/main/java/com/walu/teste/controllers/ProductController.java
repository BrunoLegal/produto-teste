package com.walu.teste.controllers;

import com.walu.teste.dto.ProductCreateDto;
import com.walu.teste.dto.ProductDto;
import com.walu.teste.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.getProduct(id));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto productCreateDto){
        return ResponseEntity.ok(productService.createProduct(productCreateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductCreateDto productCreateDto){
        try {
            return ResponseEntity.ok(productService.updateProduct(id, productCreateDto));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
