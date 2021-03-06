package com.epam.producing.testProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaxiOrderNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TaxiOrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundHandler(TaxiOrderNotFoundException ex) {
        return ex.getMessage();
    }
}
