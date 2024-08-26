package com.novasoft.springbootconsultsales.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FieldValidationError {

    private String field;
    private String error;
}
