package ru.ezuykow.examapp.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskControllerExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> missingRequestParameter(MissingServletRequestParameterException e) {
        return new ResponseEntity<>("Request must contains \"question\" and \"answer\" parameters!",
                HttpStatus.BAD_REQUEST);

    }
}
