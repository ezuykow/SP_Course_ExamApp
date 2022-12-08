package ru.ezuykow.examapp.services.examiner;

import org.springframework.stereotype.Component;
import ru.ezuykow.examapp.exceptions.MoreTaskRequestedThanExistException;
import ru.ezuykow.examapp.models.Task;

import java.util.Collection;

@Component
public class ExaminerServiceUtil {

    public void checkForAmountLessWhenTasksCount(int questionCount, int amount) {
        if (questionCount < amount) {
            throw new MoreTaskRequestedThanExistException();
        }
    }
}
