package com.todolistmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void newTaskIsIncompleteByDefault() {
        Task task = new Task("Buy milk");
        assertFalse(task.isCompleted(), "New tasks should start incomplete");
        assertEquals("Buy milk", task.getDescription());
    }

    @Test
    void markCompletedTogglesStatus() {
        Task task = new Task("Buy milk");
        task.markCompleted();
        assertTrue(task.isCompleted(), "markCompleted() should set completed=true");
        task.markCompleted();
        assertFalse(task.isCompleted(), "Calling markCompleted() again should toggle it back");
    }
}
