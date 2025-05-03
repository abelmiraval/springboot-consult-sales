package com.novasoft.springbootconsultsales.application.queries.product;

import com.novasoft.springbootconsultsales.domain.aggregates.product.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductQuery {
     Optional<List<Product>> autocomplete(@Param("isBarcodeSearch") boolean isBarcodeSearch, @Param("search") String search);
}
