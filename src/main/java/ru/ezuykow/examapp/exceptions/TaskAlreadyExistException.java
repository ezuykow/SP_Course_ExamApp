package ru.ezuykow.examapp.exceptions;

public class TaskAlreadyExistException extends RuntimeException{

    public TaskAlreadyExistException() {
        super("This task already exist!");
    }
}
