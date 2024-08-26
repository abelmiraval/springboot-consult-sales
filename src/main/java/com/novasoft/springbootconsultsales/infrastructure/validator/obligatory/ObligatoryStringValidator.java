package com.novasoft.springbootconsultsales.infrastructure.validator.obligatory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObligatoryStringValidator implements ConstraintValidator<ObligatoryString, String> {

    @Override
    public void initialize(ObligatoryString constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return value != null && (!value.trim().isEmpty());
    }

}
