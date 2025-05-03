package com.novasoft.springbootconsultsales.application.queries.product;


import com.novasoft.springbootconsultsales.domain.aggregates.product.Product;
import com.novasoft.springbootconsultsales.infrastructure.repository.IProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQuery implements IProductQuery{

    private final IProductRepository productRepository;

    public ProductQuery(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<List<Product>> autocomplete(boolean isBarcodeSearch, String search) {

        var pageable = PageRequest.of(0, 200);
        var processedSearch = search.replace(" ", "%");

        return productRepository.autocomplete(isBarcodeSearch, processedSearch, pageable);
    }


}
