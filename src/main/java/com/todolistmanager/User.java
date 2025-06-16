package com.todolistmanager;

public class User {
    private String name;
    private TaskList tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        tasks.addTask(new Task(description));
        System.out.println("Added task for " + name + ": " + description);
    }

    public void markTaskCompleted(int index) {
        System.out.println("Marking task " + index + " for " + name);
        tasks.markCompleted(index);
    }

    public void printTasks() {
        System.out.println("\nCurrent tasks for " + name + ":");
        tasks.printTasks();
    }
}
