package com.novasoft.springbootconsultsales.application.exceptions;

import com.novasoft.springbootconsultsales.application.util.Message;
import com.novasoft.springbootconsultsales.application.wrapper.BaseResponse;
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
    public BaseResponse<String> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        logger.info("Error: MethodArgumentNotValidException: {}", methodArgumentNotValidException.getMessage());

        List<FieldValidationError> fieldValidationErrorList = methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FieldValidationError(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

        BaseResponse<String> baseResponse = BaseResponse.<String>builder()
                .success(Boolean.FALSE)
                .message(Message.CODE_400)
                .errors(fieldValidationErrorList)
                .build();

        logger.info(LOG_DETAILS, methodArgumentNotValidException.getMessage());

        return baseResponse;
    }


    //
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({ConstraintViolationException.class})
//    @ResponseBody
//    public Error constraintViolationException(ConstraintViolationException constraintViolationException) {
//        logger.info("Error: ConstraintViolationException: {}", constraintViolationException.getMessage());
//
//        List<FieldValidationError.java> fieldValidationErrorList = constraintViolationException.getConstraintViolations().stream()
//                .map(fieldError -> new FieldValidationError.java(fieldError.getPropertyPath().toString(), fieldError.getMessage())).collect(
//                        Collectors.toList());
//        Error messageError = Error.builder()
//                .codigo(Constants.CODE_400)
//                .exito(Boolean.FALSE)
//                .mensaje(Message.CODE_400)
//                .errores(fieldValidationErrorList)
//                .build();
//        logger.info(LOG_DETAILS, constraintViolationException.getMessage());
//        return messageError;
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({
//            BadRequestException.class,
//            org.springframework.dao.DuplicateKeyException.class,
//            org.springframework.web.bind.support.WebExchangeBindException.class,
//            org.springframework.http.converter.HttpMessageNotReadableException.class,
//            org.springframework.web.server.ServerWebInputException.class,
//            org.springframework.web.bind.MissingServletRequestParameterException.class})
//    @ResponseBody
//    public Error badRequest(Exception badRequestException) {
//        logger.info("Error: BadRequestException: {}", badRequestException.getMessage());
//
//        Error messageError = Error.builder()
//                .codigo(Constants.CODE_400)
//                .exito(Boolean.FALSE)
//                .mensaje(Message.CODE_400)
//                .build();
//        logger.info(LOG_DETAILS, messageError);
//        return messageError;
//    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler({DataBaseException.class})
//    @ResponseBody
//    public Error dataBaseAccessException(DataBaseException dataBaseException) {
//        logger.info("Error: DataBaseException: {}", dataBaseException.getMessage());
//
//        Error messageError = Error.builder()
//                .codigo(Constants.CODE_500)
//                .exito(Boolean.FALSE)
//                .mensaje(Message.CODE_500)
//                .build();
//
//        logger.info(LOG_DETAILS, messageError);
//        return messageError;
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public BaseResponse<String> businessException(BusinessException businessException) {

        logger.info("Error: BaseException: {}", businessException.getMessage());

        List<FieldValidationError> fieldValidationErrorList = List.of(new FieldValidationError(businessException.getField(), businessException.getMessage()));

        BaseResponse<String> baseResponse = BaseResponse.<String>builder()
                .success(Boolean.FALSE)
                .message(Message.CODE_400)
                .errors(fieldValidationErrorList)
                .build();

        logger.info(LOG_DETAILS, baseResponse);

        return baseResponse;
    }

}
