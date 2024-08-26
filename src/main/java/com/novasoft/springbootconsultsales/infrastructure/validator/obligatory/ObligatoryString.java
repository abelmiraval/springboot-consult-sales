package com.novasoft.springbootconsultsales.infrastructure.validator.obligatory;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ObligatoryStringValidator.class)
public @interface ObligatoryString {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
