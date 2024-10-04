package com.clovischakrian.portfolio_api.api.controllers;

import com.clovischakrian.portfolio_api.application.dtos.ApiError;
import com.clovischakrian.portfolio_api.domain.exceptions.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = ElementNotFoundException.class)
    public ResponseEntity<Object> elementNotFoundExceptionHandler(ElementNotFoundException exception) {
        return new ResponseEntity(new ApiError(exception.getMessage(), new ArrayList<>()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> badRequestExceptionHandler(Exception exception) {
        if (!(exception instanceof MethodArgumentNotValidException)) {
            return ResponseEntity.internalServerError().body("Ouve um erro da aplicação - " + exception.getMessage());
        }

        MethodArgumentNotValidException ex = (MethodArgumentNotValidException)exception;

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ApiError("Ocorreram erros de validação", errors));
    }
}