package com.walu.teste.mapper;

import com.walu.teste.dto.ProductCreateDto;
import com.walu.teste.dto.ProductDto;
import com.walu.teste.entities.Product;
/**
 * Classe que mapeia os atributos de um produto
 * Preferi utilizar
 */
public class ProductMapper {
    public static ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    public static Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }
    //Polimorfismo para o método toEntity
    public static Product toEntity(ProductCreateDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }

}
