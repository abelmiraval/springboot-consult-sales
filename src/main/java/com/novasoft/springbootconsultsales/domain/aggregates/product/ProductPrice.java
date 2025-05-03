package com.novasoft.springbootconsultsales.domain.aggregates.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {
    private String text;
    private String label;
    private Double price;
    private Double priceTmp;
    private Double quantity;
    private boolean isPriceFraction;
}
