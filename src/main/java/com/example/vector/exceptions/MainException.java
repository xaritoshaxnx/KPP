package com.example.vector.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect parameters")
public class MainException extends RuntimeException
{
    public MainException(String message) {
        super(message);
    }
}