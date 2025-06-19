package com.todolistmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(0, list.getSize(), "A new TaskList should start with size 0");
    }

    @Test
    void addTaskIncreasesSize() {
        TaskList list = new TaskList();
        Task t1 = new Task("First");
        list.addTask(t1);
        assertEquals(1, list.getSize(), "Size should be 1 after adding one task");
    }

    @Test
    void markCompletedTogglesTaskStatus() {
        TaskList list = new TaskList();
        Task t1 = new Task("Toggle me");
        list.addTask(t1);

        assertFalse(t1.isCompleted(), "Task should start incomplete");

        list.markCompleted(0);
        assertTrue(t1.isCompleted(), "markCompleted(0) should set completed=true");

        list.markCompleted(0);
        assertFalse(t1.isCompleted(), "markCompleted(0) again should set completed=false");
    }

    @Test
    void markCompletedOnSecondTaskOnly() {
        TaskList list = new TaskList();
        Task first = new Task("One");
        Task second = new Task("Two");
        list.addTask(first);
        list.addTask(second);

        list.markCompleted(1);
        assertFalse(first.isCompleted(), "markCompleted(1) should not affect task 0");
        assertTrue(second.isCompleted(), "markCompleted(1) should mark only task 1");
    }
}
