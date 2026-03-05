package dev.santana.nook.exception;

import org.springframework.validation.FieldError;

import java.io.Serializable;

public record ValidationErrorMensage(String field, String message){
    public ValidationErrorMensage(FieldError field){
        this(field.getField(), field.getDefaultMessage());
    }
}
