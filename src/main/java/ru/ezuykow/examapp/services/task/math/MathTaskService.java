package ru.ezuykow.examapp.services.task.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.repositories.MathTasksRepository;
import ru.ezuykow.examapp.services.TaskService;

import java.util.Collection;


@Service
public class MathTaskService implements TaskService {

    private final MathTasksRepository repository;

    @Autowired
    public MathTaskService(MathTasksRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task add(String question, String answer) {
        return add(new Task(question, answer));
    }

    @Override
    public Task add(Task task) {
        return repository.add(task);
    }

    @Override
    public Task remove(String question, String answer) {
        return remove(new Task(question, answer));
    }

    @Override
    public Task remove(Task task) {
        return repository.remove(task);
    }

    @Override
    public Collection<Task> getAll() {
        return repository.getAll();
    }

    @Override
    public Task getRandomTask() {
        return repository.getRandomTask();
    }
}
