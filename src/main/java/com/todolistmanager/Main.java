package com.todolistmanager;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean running = true;
        while (running) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║    To-Do List Manager    ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println();
            System.out.println("1. Create a new user");
            System.out.println("2. Add task to a user");
            System.out.println("3. Mark a task completed");
            System.out.println("4. View a user's tasks");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Please choose an option: ");

            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1 -> createUser();
                case 2 -> addTaskToUser();
                case 3 -> markTaskCompleted();
                case 4 -> viewUserTasks();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        in.close();
    }

    private static void createUser() {
        if (userCount >= users.length) {
            System.out.println("\nCannot create more than " + users.length + " users.");
            return;
        }

        System.out.println();
        System.out.print("Please enter username: ");
        String name = in.nextLine().trim();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                System.out.println();
                System.out.println("User \"" + name + "\" already exists.");
                return;
            }
        }

        users[userCount++] = new User(name);
        System.out.println();
        System.out.println("User \"" + name + "\" created. Total users: " + userCount);
    }

    private static void addTaskToUser() {
        if (userCount == 0) {
            System.out.println("\nNo users have been created yet. Please add a user first.");
            return;
        }

        System.out.println("\nSelect a user by number:");
        System.out.println();
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + ": " + users[i].getName());
        }
        System.out.println();
        System.out.print("Enter user number: ");
        int userIndex = Integer.parseInt(in.nextLine());

        System.out.print("Enter task description: ");
        String desc = in.nextLine().trim();
        if (desc.isBlank()) {
            System.out.println();
            System.out.println("Cannot add an empty task.");
            return;
        }

        users[userIndex].addTask(desc);
    }

    private static void markTaskCompleted() {
        System.out.println("\nSelect a user by number to mark a task completed by them:");
        System.out.println();
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + ": " + users[i].getName());
        }
        System.out.println();
        System.out.print("Enter user number: ");
        int userIndex = Integer.parseInt(in.nextLine());

        System.out.println("\nTasks for " + users[userIndex].getName() + ":");
        users[userIndex].printTasks();

        System.out.println();
        System.out.print("Enter task number to mark as completed: ");
        int taskIndex = Integer.parseInt(in.nextLine());

        users[userIndex].markTaskCompleted(taskIndex);
    }

    private static void viewUserTasks() {
        if (userCount == 0) {
            System.out.println(
                    "\nThere are no users currently registered, please add a user and come back once a task has been assigned to them.");
            return;
        }

        System.out.println("\nSelect a user by number to view their current task list:");
        System.out.println();
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + ": " + users[i].getName());
        }
        System.out.println();
        System.out.print("Enter user number: ");

        int userIndex = Integer.parseInt(in.nextLine());

        users[userIndex].printTasks();
    }
}
