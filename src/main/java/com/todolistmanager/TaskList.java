package com.todolistmanager;

public class TaskList {
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
        }
    }

    private Node head;
    private int size;

    public void addTask(Task newTask) {
        Node node = new Node(newTask);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    public void markCompleted(int position) {
        // TODO: start at head, move `position` times, then call task.markCompleted()
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks to show.");
            return;
        }
        Node curr = head;
        int index = 0;
        while (curr != null) {
            System.out.println(index + ": " + curr.task);
            curr = curr.next;
            index++;
        }
    }

    public int getSize() {
        return size;
    }
}
