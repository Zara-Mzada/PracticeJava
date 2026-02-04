package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IsNullException.class)
    public ResponseEntity<String> handleIsNull(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Null variable!");
    }

    @ExceptionHandler(FormatInvalidException.class)
    public ResponseEntity<String> handleFormatInvalid(){
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Format is invalid!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<String>> handleValidation(MethodArgumentNotValidException ex){
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));
    }

}
