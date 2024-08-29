package com.novasoft.springbootconsultsales.application.exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

}
