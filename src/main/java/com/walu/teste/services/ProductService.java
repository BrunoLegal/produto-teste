package com.walu.teste.services;

import com.walu.teste.dto.ProductCreateDto;
import com.walu.teste.dto.ProductDto;
import com.walu.teste.entities.Product;
import com.walu.teste.mapper.ProductMapper;
import com.walu.teste.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe que contém a lógica de negócio para a entidade Produto
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional //Para garantir que a operação seja realizada com sucesso
    public ProductDto createProduct(ProductCreateDto productCreateDto){
        Product product = ProductMapper.toEntity(productCreateDto);
        return ProductMapper.toDto(productRepository.save(product));
    }

    public ProductDto getProduct(Long id){
        return ProductMapper.toDto(productRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Produto não encontrado")));
    }
    @Transactional
    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new NoSuchElementException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductDto updateProduct(Long id, ProductCreateDto productCreateDto){
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
        product.setName(productCreateDto.getName());
        product.setPrice(productCreateDto.getPrice());
        product.setQuantity(productCreateDto.getQuantity());
        return ProductMapper.toDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toDto).toList(); //cria uma stream da lista de produtos e mapeia cada elemento para uma lista de ProductDto
    }
}
