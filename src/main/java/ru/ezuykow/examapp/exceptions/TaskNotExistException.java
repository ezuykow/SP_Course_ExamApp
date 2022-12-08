package ru.ezuykow.examapp.exceptions;

public class TaskNotExistException extends RuntimeException{

    public TaskNotExistException() {
        super("This task is not exist!");
    }
}
