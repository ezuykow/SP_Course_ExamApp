package ru.ezuykow.examapp.models;

import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {

    private final String question;
    private final String answer;

    public Task(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!Objects.equals(question, task.question)) return false;
        return Objects.equals(answer, task.answer);
    }

    @Override
    public int hashCode() {
        int result = question != null ? question.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "question: '" + question + '\'' +
                ", answer: '" + answer + '\'' +
                '}';
    }
}
