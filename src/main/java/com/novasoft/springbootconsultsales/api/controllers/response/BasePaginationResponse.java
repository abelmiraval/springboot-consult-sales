package com.novasoft.springbootconsultsales.api.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BasePaginationResponse<T> {
    private T data;
    private int page;
    private int size;
    private String message;
    private boolean status;
}
