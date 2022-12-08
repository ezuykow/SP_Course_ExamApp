package ru.ezuykow.examapp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.examapp.exceptions.TaskAlreadyExistException;
import ru.ezuykow.examapp.exceptions.TaskNotExistException;
import ru.ezuykow.examapp.models.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasksRepositoriesUtilTest {

    private TasksRepositoriesUtil utils;
    private List<Task> tasks;

    @BeforeEach
    public void setUp() {
        utils = new TasksRepositoriesUtil();
        tasks = new ArrayList<>(List.of(
                new Task("1", "111"),
                new Task("2", "222"),
                new Task("3", "333")
        ));
    }

    @Test
    public void shouldThrowTaskAlreadyExistExceptionIfTaskExistButMustNotExist() {
        final Task task = new Task("1", "111");
        assertThrows(TaskAlreadyExistException.class,
                () -> utils.checkExistenceOfTask(tasks, task, false));
    }

    @Test
    public void shouldReturnTaskNotExistExceptionIfTaskNotExistButMustExist() {
        final Task task = new Task("4", "444");
        assertThrows(TaskNotExistException.class,
                () -> utils.checkExistenceOfTask(tasks, task, true));
    }

    @Test
    public void shouldReturnRandomTaskIndexInRightBounds() {
        final int randIndex = utils.getRandomTaskIndex(tasks);
        assertTrue((randIndex > -1) && (randIndex < tasks.size()));
    }
}