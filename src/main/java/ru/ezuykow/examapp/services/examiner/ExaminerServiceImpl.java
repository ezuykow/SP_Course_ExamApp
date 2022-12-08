package ru.ezuykow.examapp.services.examiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.services.ExaminerService;
import ru.ezuykow.examapp.services.TaskService;
import ru.ezuykow.examapp.services.task.math.MathTaskService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final TaskService javaTaskService;
    private final MathTaskService mathTaskService;
    private final ExaminerServiceUtil utils;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaTaskService") TaskService javaTaskService,
                               MathTaskService mathTaskService,
                               ExaminerServiceUtil utils) {
        this.javaTaskService = javaTaskService;
        this.mathTaskService = mathTaskService;
        this.utils = utils;
    }

    @Override
    public Collection<Task> getTasks(int amount) {
        int maxQuestionCount = javaTaskService.getAll().size() * 2;
        utils.checkForAmountLessWhenTasksCount(maxQuestionCount, amount);

        Set<Task> tasks = new HashSet<>(amount);
        Random r = new Random();
        while (tasks.size() < amount) {
            switch (r.nextInt(2)) {
                case 0:
                    tasks.add(javaTaskService.getRandomTask());
                    break;
                case 1:
                    tasks.add(mathTaskService.getRandomTask());
                    break;
                default:
                    break;
            }
        }

        return tasks;
    }
}
