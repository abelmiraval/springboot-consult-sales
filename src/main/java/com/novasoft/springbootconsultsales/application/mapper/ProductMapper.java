package com.novasoft.springbootconsultsales.application.mapper;

import com.novasoft.springbootconsultsales.api.controllers.response.product.ProductResponse;
import com.novasoft.springbootconsultsales.application.dto.ProductPriceDTO;
import com.novasoft.springbootconsultsales.domain.aggregates.product.Product;
import com.novasoft.springbootconsultsales.domain.aggregates.product.ProductPrice;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        componentModel = "spring")
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "fullDescription", expression = "java(product.getFullDescription())")
    @Mapping(target = "cost", expression = "java(product.getCost(exchangeRate))")
    @Mapping(target = "price", expression = "java(product.getPrice(exchangeRate))")
    @Mapping(target = "priceFra", expression = "java(product.getPriceFra(exchangeRate))")
    @Mapping(target = "quantity", expression = "java(product.getQuantity())")
    @Mapping(target = "measureUnit", expression = "java(product.getMeasureUnit())")
    @Mapping(target = "prices", expression = "java(toProductPriceDTOs(product.getPrices(exchangeRate)))")
    ProductResponse productToResponse(Product product, @Context double exchangeRate);

    List<ProductResponse> productsToResponse(List<Product> products, @Context double exchangeRate);

    default List<ProductPriceDTO> toProductPriceDTOs(List<ProductPrice> prices) {
        return prices.stream()
                .map(p -> new ProductPriceDTO(p.getText(), p.getLabel(), p.getPrice(), p.getPrice(), p.getQuantity(), p.isPriceFraction()))
                .toList();
    }
}