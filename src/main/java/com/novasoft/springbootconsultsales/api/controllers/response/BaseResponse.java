package com.novasoft.springbootconsultsales.api.controllers.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseResponse<T> {
    public T data;
    public String message;
    public boolean status;
}
