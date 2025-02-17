package com.walu.teste.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
