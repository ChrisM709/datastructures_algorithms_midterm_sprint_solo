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
            System.out.println("4. View a user’s tasks");
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
        System.out.print("Please enter username: ");
        String name = in.nextLine().trim();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                System.out.println("User \"" + name + "\" already exists.");
                return;
            }
        }
        
        users[userCount++] = new User(name);
        System.out.println("User \"" + name + "\" created. Total users: " + userCount);
    }

    private static void addTaskToUser() {
        // Placeholder
    }

    private static void markTaskCompleted() {
        // Placeholder
    }

    private static void viewUserTasks() {
        // Placeholder
    }
}
