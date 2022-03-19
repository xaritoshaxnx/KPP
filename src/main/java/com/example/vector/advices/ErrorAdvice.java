package com.example.vector.advices;


import com.example.vector.responses.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.rmi.ServerException;


@RestControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionResponse> handleException(ServerException except) {
        logger.error("Error 400", except);
        return new ResponseEntity<>(new ExceptionResponse(except.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception except) {
        logger.error("Error 500", except);
        return new ResponseEntity<>(new ExceptionResponse(except.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentTypeMismatchException except){
        logger.error("Error format parameter",except);
        return new ResponseEntity<>(new ExceptionResponse(except.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
