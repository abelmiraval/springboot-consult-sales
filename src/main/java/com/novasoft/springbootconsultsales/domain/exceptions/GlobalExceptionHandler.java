package com.novasoft.springbootconsultsales.domain.exceptions;

import com.novasoft.springbootconsultsales.application.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.novasoft.springbootconsultsales")
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger("ErrorGlobalExceptionHandler");
    private static final String LOG_DETAILS = "Detail: {} ";


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public BaseError methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        logger.info("Error: MethodArgumentNotValidException: {}", methodArgumentNotValidException.getMessage());

        List<FieldValidationError> fieldValidationErrorList = methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FieldValidationError(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

        BaseError baseError = BaseError.builder()
                .success(Boolean.FALSE)
                .message(Message.CODE_400)
                .errors(fieldValidationErrorList)
                .build();

        logger.info(LOG_DETAILS, methodArgumentNotValidException.getMessage());

        return baseError;
    }

}
