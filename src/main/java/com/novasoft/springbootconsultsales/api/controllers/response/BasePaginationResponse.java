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
    public T data;
    public int page;
    public int size;
    public String message;
    public boolean status;
}
