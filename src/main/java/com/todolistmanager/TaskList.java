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
        // TODO: start at head, loop through each node, and do
        // System.out.println(node.task)
    }

    public int getSize() {
        return size;
    }
}
