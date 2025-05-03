package com.novasoft.springbootconsultsales.api.controllers.response.product;

import com.novasoft.springbootconsultsales.application.dto.ProductPriceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String code;
    private String codeTwo;
    private String barCode;
    private String currency;
    private String type;
    private String taxType;
    private String description;
    private Double priceOne;
    private Double priceTwo;
    private Double priceThree;
    private Double priceFour;
    private Double priceFive;
    private Double priceFraction;
    private Double minQuantityOne;
    private Double minQuantityTwo;
    private Double minQuantityThree;
    private Double minQuantityFour;
    private Double minQuantityFive;
    private Double pricePerQuantity;
    private String measure;
    private String measureFraction;
    private Double fraction;
    private Double igv;
    private String brand;
    private String fullDescription;
    private double cost;
    private double price;
    private double priceFra;
    private double quantity;
    private double measureUnit;
    private List<ProductPriceDTO> prices;

}
