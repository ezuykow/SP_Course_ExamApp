package ru.ezuykow.examapp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.utils.TaskType;
import ru.ezuykow.examapp.utils.TasksFileWorker;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class JavaTasksRepository {

    private final List<Task> tasks;
    private final TasksRepositoriesUtil util;
    private final TasksFileWorker fileWorker;

    @Autowired
    public JavaTasksRepository(TasksRepositoriesUtil util, TasksFileWorker fileWorker) {
        this.util = util;
        this.fileWorker = fileWorker;
        tasks = this.fileWorker.getTasksFromFile(TaskType.JAVA);
    }

    public Task add(Task task) {
        util.checkExistenceOfTask(tasks, task, false);
        tasks.add(task);
        fileWorker.refreshTasksFile(TaskType.JAVA, tasks);
        return task;
    }

    public Task remove(Task task) {
        util.checkExistenceOfTask(tasks, task, true);
        tasks.remove(task);
        fileWorker.refreshTasksFile(TaskType.JAVA, tasks);
        return task;
    }

    public Collection<Task> getAll() {
        return tasks;
    }

    public Task getRandomTask() {
        return tasks.get(util.getRandomTaskIndex(tasks));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaTasksRepository that = (JavaTasksRepository) o;

        if (!Objects.equals(tasks, that.tasks)) return false;
        return Objects.equals(util, that.util);
    }

    @Override
    public int hashCode() {
        int result = tasks != null ? tasks.hashCode() : 0;
        result = 31 * result + (util != null ? util.hashCode() : 0);
        return result;
    }
}
