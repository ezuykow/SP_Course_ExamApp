package ru.ezuykow.examapp.services.task.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.repositories.MathTasksRepository;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathTaskServiceTest {

    @Mock
    private MathTasksRepository repository;

    @InjectMocks
    private MathTaskService service;

    @Test
    public void shouldReturnAddedTask() {
        final String question = "1";
        final String answer = "111";
        final Task actual = new Task(question, answer);
        when(repository.add(actual)).thenReturn(actual);

        Task expected1 = service.add(question, answer);
        Task expected2 = service.add(actual);

        assertEquals(expected1, actual);
        assertEquals(expected2, actual);
    }

    @Test
    public void shouldReturnRemovedTask() {
        final String question = "1";
        final String answer = "111";
        final Task actual = new Task(question, answer);
        when(repository.remove(actual)).thenReturn(actual);

        Task expected1 = service.remove(question, answer);
        Task expected2 = service.remove(actual);

        assertEquals(expected1, actual);
        assertEquals(expected2, actual);
    }

    @Test
    public void shouldReturnAllTasks() {
        Collection<Task> actual = List.of(
                new Task("1", "111"),
                new Task("2", "222")
        );
        when(repository.getAll()).thenReturn(actual);
        Collection<Task> expected = service.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRandomTask() {
        Task actual = new Task("1", "111");
        when(repository.getRandomTask()).thenReturn(actual);
        Task expected = service.getRandomTask();

        assertEquals(expected, actual);
    }
}