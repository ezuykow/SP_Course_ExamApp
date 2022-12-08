package ru.ezuykow.examapp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ezuykow.examapp.exceptions.TaskAlreadyExistException;
import ru.ezuykow.examapp.exceptions.TaskNotExistException;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.utils.TaskType;
import ru.ezuykow.examapp.utils.TasksFileWorker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaTasksRepositoryTest {

    @Mock
    private TasksFileWorker fileWorker;

    @InjectMocks
    private JavaTasksRepository repository;

    private List<Task> tasks;

    @BeforeEach
    public void setUp() {
        tasks = new ArrayList<>(List.of(
                new Task("1", "111"),
                new Task("2", "222")
        ));

        when(fileWorker.getTasksFromFile(TaskType.JAVA)).thenReturn(tasks);

        repository = new JavaTasksRepository(new TasksRepositoriesUtil(), fileWorker);
    }

    @Test
    public void shouldReturnAddedTask() {
        when(fileWorker.refreshTasksFile(TaskType.JAVA, tasks)).thenReturn(true);
        final Task actual = new Task("3", "333");
        final Task expected = repository.add(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowTaskAlreadyExistExceptionIfTaskAlreadyExistWhenTryToAdd() {
        final Task newTask = new Task("1", "111");
        assertThrows(TaskAlreadyExistException.class,
                () -> repository.add(newTask));
    }

    @Test
    public void shouldReturnRemovedTask() {
        when(fileWorker.refreshTasksFile(TaskType.JAVA, tasks)).thenReturn(true);
        final Task actual = new Task("1", "111");
        final Task expected = repository.remove(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowTaskNotExistExceptionIfTaskNotExistWhenTryToRemove() {
        final Task task = new Task("3", "333");
        assertThrows(TaskNotExistException.class,
                () -> repository.remove(task));
    }

    @Test
    public void shouldReturnAllTasksWhenCall() {
        Collection<Task> expected = repository.getAll();
        Collection<Task> actual = tasks;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRandomTask() {
        Task expected = repository.getRandomTask();
        assertTrue(tasks.contains(expected));
    }
}