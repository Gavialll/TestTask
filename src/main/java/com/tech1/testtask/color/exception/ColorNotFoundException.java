package com.tech1.testtask.color.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Color not found")
public class ColorNotFoundException extends RuntimeException{
    public ColorNotFoundException(String message) {
        super(message);
    }
}
