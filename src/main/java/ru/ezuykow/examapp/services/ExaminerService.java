package ru.ezuykow.examapp.services;

import ru.ezuykow.examapp.models.Task;

import java.util.Collection;

public interface ExaminerService {

    Collection<Task> getTasks(int amount);
}
