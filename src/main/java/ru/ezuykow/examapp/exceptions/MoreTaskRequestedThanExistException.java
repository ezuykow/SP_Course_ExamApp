package ru.ezuykow.examapp.exceptions;

public class MoreTaskRequestedThanExistException extends RuntimeException{

    public MoreTaskRequestedThanExistException() {
        super("More unique task requested than exist!");
    }
}
