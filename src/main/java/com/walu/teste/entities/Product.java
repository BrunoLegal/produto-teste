package com.walu.teste.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Classe de entidade do produto
 */
@Entity
@Data
@Table(name = "products") //para garantir que a tabela seja a mesma com o nome descrito no PDF
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Anotação Not Null na entidade para garantir que nenhum valor inserido seja nulo
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;

}
