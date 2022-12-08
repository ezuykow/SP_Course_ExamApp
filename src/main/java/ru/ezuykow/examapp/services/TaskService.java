package ru.ezuykow.examapp.services;

import ru.ezuykow.examapp.models.Task;

import java.util.Collection;

public interface TaskService {

    Task add(String question, String answer);

    Task add(Task task);

    Task remove(String question, String answer);

    Task remove(Task task);

    Collection<Task> getAll();

    Task getRandomTask();
}
