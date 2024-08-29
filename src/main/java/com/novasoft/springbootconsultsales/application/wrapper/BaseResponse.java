package com.novasoft.springbootconsultsales.application.wrapper;

import com.novasoft.springbootconsultsales.application.exceptions.FieldValidationError;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BaseResponse<T> {
    private T data;
    private String message;
    private boolean success;
    private List<FieldValidationError> errors;

}