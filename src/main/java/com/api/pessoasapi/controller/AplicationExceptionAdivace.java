package com.api.pessoasapi.controller;

import com.api.pessoasapi.service.exceptions.RecordNotFoundExcepition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Handler;
@RestControllerAdvice
public class AplicationExceptionAdivace {
    @ExceptionHandler(RecordNotFoundExcepition.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String HandleNotFoundException(ReflectiveOperationException ex){
        return ex.getMessage();
    }
}
