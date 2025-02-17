package com.walu.teste.repositories;

import com.walu.teste.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Interface que extende a JpaRepository para realizar operações de CRUD no banco de dados
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
