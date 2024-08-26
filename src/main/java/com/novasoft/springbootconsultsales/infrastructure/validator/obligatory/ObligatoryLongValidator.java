package com.novasoft.springbootconsultsales.infrastructure.validator.obligatory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObligatoryLongValidator implements ConstraintValidator<ObligatoryLong, Long> {

    @Override
    public void initialize(ObligatoryLong constraintAnnotation) {
        // constraintAnnotation
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        return value != null && value > 0;
    }
}
