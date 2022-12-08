package ru.ezuykow.examapp.services.task.math;

import org.springframework.stereotype.Service;
import ru.ezuykow.examapp.models.Task;

import java.util.Random;


@Service
public class MathTaskService {

    private static final int MAX_ANSWER_FOR_ADDITION_AND_MULTIPLY = 1_000_000;
    private static final int MAX_ANSWER_FOR_DIVISION = 1_000;
    private static final int MAX_ANSWER_FOR_SUBTRACTION = 100_000;
    private static final int MAX_OPERAND = 1_000_000;

    private Random random;

    public Task getRandomTask() {
        return createTask();
    }

    private Task createTask() {
        random = new Random();

        final char action = generateAction();
        final int intAnswer = generateAnswer(action);
        final String question = generateQuestion(action, intAnswer);

        return new Task(question, String.valueOf(intAnswer));
    }

    private char generateAction() {
        switch (random.nextInt(4)) {
            case 1:
                return '-';
            case 2:
                return '*';
            case 3:
                return '/';
            default:
                return '+';
        }
    }

    private int generateAnswer(char action) {
        switch (action) {
            case '-':
                return random.nextInt(MAX_ANSWER_FOR_SUBTRACTION);
            case '/':
                return random.nextInt(MAX_ANSWER_FOR_DIVISION);
            case '+':
            case '*':
            default:
                return random.nextInt(MAX_ANSWER_FOR_ADDITION_AND_MULTIPLY);
        }
    }

    private String generateQuestion(char action, int answer) {
        switch (action) {
            case '+':
                return generateAdditionQuestion(answer);
            case '*':
                return generateMultiplyQuestion(answer);
            case '-':
                return generateSubtractionQuestion(answer);
            case '/':
            default:
                return generateDivisionQuestion(answer);
        }
    }

    private String generateAdditionQuestion(int answer) {
        int a = random.nextInt(answer/2) + 1;
        int b = answer - a;
        return a + " + " + b;
    }

    private String generateMultiplyQuestion(int answer) {
        int a, b;
        do {
            a = random.nextInt(answer / 2) + 1;
            b = answer / a;
        } while (answer % a != 0);
        return a + " * " + b;
    }

    private String generateSubtractionQuestion(int answer) {
        int a = random.nextInt(MAX_OPERAND - answer) + answer;
        int b = answer + a;
        return b + " - " + a;
    }

    private String generateDivisionQuestion(int answer) {
        int a = random.nextInt(answer) + 1;
        int b = answer * a;
        return b + " / " + a;
    }
}
