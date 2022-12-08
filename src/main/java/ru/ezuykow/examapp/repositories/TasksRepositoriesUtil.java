package ru.ezuykow.examapp.repositories;

import org.springframework.stereotype.Component;
import ru.ezuykow.examapp.exceptions.TaskAlreadyExistException;
import ru.ezuykow.examapp.exceptions.TaskNotExistException;
import ru.ezuykow.examapp.models.Task;

import java.util.List;
import java.util.Random;

@Component
public class TasksRepositoriesUtil {

    public void checkExistenceOfTask(List<Task> tasks, Task task, Boolean mustExist) {
        final boolean isExist = tasks.contains(task);
        if (isExist && !mustExist) {
            throw new TaskAlreadyExistException();
        }
        if (mustExist && !isExist) {
            throw new TaskNotExistException();
        }
    }

    public int getRandomTaskIndex(List<Task> tasks) {
        Random r = new Random();
        return r.nextInt(tasks.size());
    }
}
