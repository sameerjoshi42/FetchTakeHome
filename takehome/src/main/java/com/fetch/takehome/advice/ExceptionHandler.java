package com.fetch.takehome.advice;

import com.fetch.takehome.exception.DateFormatException;
import com.fetch.takehome.exception.ReceiptProcessorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleInvalidInput(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ReceiptProcessorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(ReceiptProcessorException ex){
        return ex.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDateFormat(DateFormatException ex){
        return ex.getMessage();
    }


}
