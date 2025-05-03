package com.novasoft.springbootconsultsales.domain.aggregates.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "idproducto")
    private String id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "codigo2")
    private String codeTwo;

    @Column(name = "codigo_bar")
    private String barCode;

    @Column(name = "moneda")
    private String currency;

    @Column(name = "tipo")
    private String type;

    @Column(name = "tipo_imp")
    private String taxType;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Double price;

    @Column(name = "precio1")
    private Double priceOne;

    @Column(name = "precio2")
    private Double priceTwo;

    @Column(name = "precio3")
    private Double priceThree;

    @Column(name = "precio4")
    private Double priceFour;

    @Column(name = "precio5")
    private Double priceFive;

    @Column(name = "precio_fra")
    private Double priceFraction;

    @Column(name = "cant_min1")
    private Double minQuantityOne;

    @Column(name = "cant_min2")
    private Double minQuantityTwo;

    @Column(name = "cant_min3")
    private Double minQuantityThree;

    @Column(name = "cant_min4")
    private Double minQuantityFour;

    @Column(name = "cant_min5")
    private Double minQuantityFive;

    @Column(name = "prec_x_cantidad")
    private Double pricePerQuantity;

    @Column(name = "medida")
    private String measure;

    @Column(name = "medida_fra")
    private String measureFraction;

    @Column(name = "fraccion")
    private Double fraction;

    @Column(name = "costor")
    private Double cost;

    @Column(name = "igv")
    private Double igv;

    @Column(name = "marca")
    private String brand;

    @Column(name = "idlocal")
    private Integer localId;

    @Column(name = "estado")
    private String state;


    public String getFullDescription() {
        return description + " | " + code;
    }

    public double getCost(double exchangeRate) {

        var priceWithExchangeRate = getPriceWithExchangeRate(cost, exchangeRate);

        return getPriceWithIgv(isTaxable(), priceWithExchangeRate);
    }

    public double getPrice(double exchangeRate) {

        var priceWithExchangeRate = getPriceWithExchangeRate(price, exchangeRate);

        return getPriceWithIgv(isTaxable(), priceWithExchangeRate);
    }

    public double getPriceFra(double exchangeRate) {

        var priceWithExchangeRate = getPriceWithExchangeRate(priceFraction, exchangeRate);

        return getPriceWithIgv(isTaxable(), priceWithExchangeRate);
    }

    public double getQuantity() {
        return 1;
    }

    public double getMeasureUnit(){
        return 1;
    }

    public List<ProductPrice> getPrices(double exchangeRate) {
        List<ProductPrice> prices = new ArrayList<>();

        double[] values = {
                price, priceOne, priceTwo, priceThree, priceFour, priceFive, priceFraction
        };

        double[] quantities = {
                1,
                minQuantityOne,
                minQuantityTwo,
                minQuantityThree,
                minQuantityFour,
                minQuantityFive,
                1
        };

        String[] labels = {"P0", "P1", "P2", "P3", "P4", "P5", "PFR"};

        for (int i = 0; i < values.length; i++) {
            double raw = values[i];
            if (raw > 0) {
                double priceWithExchangeRate = getPriceWithExchangeRate(raw, exchangeRate);
                double priceWithIgv = getPriceWithIgv(isTaxable(), priceWithExchangeRate);

                prices.add(new ProductPrice(
                        getFullDescription(),
                        labels[i],
                        priceWithIgv,
                        priceWithIgv,
                        quantities[i],
                        labels[i].equals("PFR")
                ));
            }
        }

        return prices;
    }

    public double getPriceWithIgv(boolean applyIgv, double base) {
        return applyIgv ? base * (1 + ((double) 18 /100)) : base;
    }

    public double getPriceWithExchangeRate(double value, double exchangeRate) {
        return isDollar() ? value * exchangeRate : value;
    }

    public boolean isDollar() {
        return "US$".equals(currency);
    }

    public boolean isTaxable() {
        return "G".equalsIgnoreCase(taxType);
    }
}
