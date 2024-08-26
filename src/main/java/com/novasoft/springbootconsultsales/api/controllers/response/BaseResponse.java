package com.novasoft.springbootconsultsales.api.controllers.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseResponse<T> {
    private T data;
    private String message;
    private boolean status;
}
