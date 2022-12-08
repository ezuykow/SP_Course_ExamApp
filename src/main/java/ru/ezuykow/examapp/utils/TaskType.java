package ru.ezuykow.examapp.utils;

import java.io.File;

public enum TaskType {
    JAVA("src/main/java/ru/ezuykow/examapp/files/JavaTasks.bin"),
    MATH("src/main/java/ru/ezuykow/examapp/files/MathTasks.bin");

    private final String path;

    TaskType(String path) {
        this.path = path;
    }

    public File getFile() {
        return new File(path);
    }
}
