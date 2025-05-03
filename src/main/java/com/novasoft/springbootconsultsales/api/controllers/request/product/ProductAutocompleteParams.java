package com.novasoft.springbootconsultsales.api.controllers.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAutocompleteParams {
    @NotNull
    public Boolean isBarcodeSearch;
    @NotNull
    public String search;

}
