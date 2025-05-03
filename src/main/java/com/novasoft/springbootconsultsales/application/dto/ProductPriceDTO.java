package com.novasoft.springbootconsultsales.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDTO {
    private String text;
    private String label;
    private double price;
    private double priceTmp;
    private double quantity;
    private boolean isPriceFraction;
}
