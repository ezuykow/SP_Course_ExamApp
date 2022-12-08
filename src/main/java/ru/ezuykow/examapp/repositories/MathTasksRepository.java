package ru.ezuykow.examapp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.utils.TaskType;
import ru.ezuykow.examapp.utils.TasksFileWorker;

import java.util.Collection;
import java.util.List;

@Repository
public class MathTasksRepository {


    private final List<Task> tasks;
    private final TasksRepositoriesUtil util;
    private final TasksFileWorker fileWorker;

    @Autowired
    public MathTasksRepository(TasksRepositoriesUtil util, TasksFileWorker fileWorker) {
        this.util = util;
        this.fileWorker = fileWorker;
        tasks = this.fileWorker.getTasksFromFile(TaskType.MATH);
    }

    public Task add(Task task) {
        util.checkExistenceOfTask(tasks, task, false);
        tasks.add(task);
        fileWorker.refreshTasksFile(TaskType.MATH, tasks);
        return task;
    }

    public Task remove(Task task) {
        util.checkExistenceOfTask(tasks, task, true);
        tasks.remove(task);
        fileWorker.refreshTasksFile(TaskType.MATH, tasks);
        return task;
    }

    public Collection<Task> getAll() {
        return tasks;
    }

    public Task getRandomTask() {
        return tasks.get(util.getRandomTaskIndex(tasks));
    }
}