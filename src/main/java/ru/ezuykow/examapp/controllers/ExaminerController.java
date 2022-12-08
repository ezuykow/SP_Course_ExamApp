package ru.ezuykow.examapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ezuykow.examapp.models.Task;
import ru.ezuykow.examapp.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExaminerController {

    private final ExaminerService examinerService;

    @Autowired
    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Task> getRandomTasks(@PathVariable("amount") int amount) {
        return examinerService.getTasks(amount);
    }
}
