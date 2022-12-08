package ru.ezuykow.examapp.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ezuykow.examapp.exceptions.TaskAlreadyExistException;
import ru.ezuykow.examapp.exceptions.TaskNotExistException;

@ControllerAdvice
public class TaskServiceExceptionHandler {

    @ExceptionHandler(TaskAlreadyExistException.class)
    public ResponseEntity<Object> taskAlreadyExist(TaskAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotExistException.class)
    public ResponseEntity<Object> taskNotExist(TaskNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
