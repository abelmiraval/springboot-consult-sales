package com.novasoft.springbootconsultsales.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldValidationError {
    private String field;
    private String error;
}