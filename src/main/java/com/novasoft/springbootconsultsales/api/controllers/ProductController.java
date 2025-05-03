package com.novasoft.springbootconsultsales.api.controllers;

import com.novasoft.springbootconsultsales.api.controllers.request.product.ProductAutocompleteParams;
import com.novasoft.springbootconsultsales.api.controllers.response.product.ProductResponse;
import com.novasoft.springbootconsultsales.application.mapper.ProductMapper;
import com.novasoft.springbootconsultsales.application.queries.product.IProductQuery;
import com.novasoft.springbootconsultsales.application.wrapper.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductQuery productQuery;
    public final ProductMapper productMapper;

    public static final String SUCCESS = "Success";


    public ProductController(IProductQuery productQuery, ProductMapper productMapper) {
        this.productQuery = productQuery;
        this.productMapper = productMapper;
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<BaseResponse<List<ProductResponse>>> autocomplete(@Validated ProductAutocompleteParams params) {
        var optional = productQuery.autocomplete(params.isBarcodeSearch, params.search);
//        var response = optional.map(ProductMapper.INSTANCE::productsToResponse).orElse(null);
        var response = productMapper.productsToResponse(optional.orElse(List.of()), 3.7);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true, new ArrayList<>()), HttpStatus.OK);
    }


}
