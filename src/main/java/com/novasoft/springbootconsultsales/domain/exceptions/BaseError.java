package com.novasoft.springbootconsultsales.domain.exceptions;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseError {
    private Boolean success;
    private String message;
    private String description;
    private List<FieldValidationError> errors;
}
