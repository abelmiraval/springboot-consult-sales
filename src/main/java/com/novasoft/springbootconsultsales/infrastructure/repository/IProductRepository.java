package com.novasoft.springbootconsultsales.infrastructure.repository;

import com.novasoft.springbootconsultsales.domain.aggregates.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends IBaseRepository<Product, String> {

    @Query("SELECT new com.novasoft.springbootconsultsales.domain.aggregates.product.Product(" +
            "p.id, " +
            "p.code, " +
            "p.codeTwo, " +
            "p.barCode, " +
            "p.currency, " +
            "p.type, " +
            "p.taxType, " +
            "p.description, " +
            "p.price, " +
            "p.priceOne, " +
            "p.priceTwo, " +
            "p.priceThree, " +
            "p.priceFour, " +
            "p.priceFive, " +
            "p.priceFraction, " +
            "p.minQuantityOne, " +
            "p.minQuantityTwo, " +
            "p.minQuantityThree, " +
            "p.minQuantityFour, " +
            "p.minQuantityFive, " +
            "p.pricePerQuantity, " +
            "p.measure, " +
            "p.measureFraction, " +
            "p.fraction, " +
            "p.cost, " +
            "p.igv, " +
            "p.brand, " +
            "p.localId, " +
            "p.state) " +
            "FROM Product p " +
            "WHERE p.state = 'A'  " +
            "AND (p.localId = 1 OR p.localId = 0) " +
            "AND ((:isBarcodeSearch = true AND p.barCode = :search) OR (:isBarcodeSearch = false AND (LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.code) LIKE LOWER(CONCAT('%', :search, '%')))))" +
            "GROUP BY p.id")
    Optional<List<Product>> autocomplete(@Param("isBarcodeSearch") boolean isBarcodeSearch, @Param("search") String search, Pageable pageable);

}