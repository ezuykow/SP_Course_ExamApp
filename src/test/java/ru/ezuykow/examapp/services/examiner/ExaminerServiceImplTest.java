package ru.ezuykow.examapp.services.examiner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.services.ExaminerService;
import ru.ezuykow.examapp.services.task.java.JavaTaskService;
import ru.ezuykow.examapp.services.task.math.MathTaskService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaTaskService javaTaskService;
    @Mock
    private MathTaskService mathTaskService;

    @Test
    public void shouldReturnCollectionOfTasks() {
        ExaminerService examinerService = new ExaminerServiceImpl(javaTaskService, mathTaskService,
                new ExaminerServiceUtil());

        List<Task> javaTasks = List.of(
                new Task("1", "111"),
                new Task("2", "222")
        );
        List<Task> mathTasks = List.of(
                new Task("!", "!!!"),
                new Task("@", "@@@")
        );
        Set<Task> actual = new HashSet<>(List.of(
                mathTasks.get(0),
                javaTasks.get(0)
        ));

        when(javaTaskService.getAll()).thenReturn(javaTasks);
        when(mathTaskService.getAll()).thenReturn(mathTasks);
        when(javaTaskService.getRandomTask()).thenReturn(mathTasks.get(0));
        when(mathTaskService.getRandomTask()).thenReturn(javaTasks.get(0));

        Collection<Task> expected = examinerService.getTasks(2);

        assertEquals(expected, actual);
    }
}