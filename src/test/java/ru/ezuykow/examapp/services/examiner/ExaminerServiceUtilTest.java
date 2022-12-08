package ru.ezuykow.examapp.services.examiner;

import org.junit.jupiter.api.Test;
import ru.ezuykow.examapp.exceptions.MoreTaskRequestedThanExistException;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceUtilTest {

    private final ExaminerServiceUtil utils = new ExaminerServiceUtil();

    @Test
    public void shouldThrowMoreTaskRequestedWhenExistExceptionIfAmountMoreWhenQuestionCount() {
        assertThrows(MoreTaskRequestedThanExistException.class,
                () -> utils.checkForAmountLessWhenTasksCount(3, 4));
    }
}