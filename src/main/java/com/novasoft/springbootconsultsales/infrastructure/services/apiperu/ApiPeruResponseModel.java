package com.novasoft.springbootconsultsales.infrastructure.services.apiperu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiPeruResponseModel<T> {

    private boolean success;
    private T data;
    private double time;
    private String source;
}

