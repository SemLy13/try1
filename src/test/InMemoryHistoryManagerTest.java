package test;

import Tasks.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    void EmptyHistory(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        ArrayList<Task> history = imhm.getHistoryForBack();
        assertNotNull(history, "Список истории не должен быть null.");
        assertTrue(history.isEmpty(), "Список истории должен быть пустым.");
    }
    @Test
    void duplication() {
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Task task1 = new Task("Task 1", "Task description");
        manager.addTask(task1);
        Task task2 = new Task("Task 2", "Yes");
        manager.addTask(task2);
        imhm.add(task1);
        imhm.add(task2);
        imhm.add(task1);
        ArrayList<Task> history = imhm.getHistoryForBack();
        Set<Task> uniqueTasks = new HashSet<>(history);
        assertEquals(uniqueTasks.size(), history.size(), "Список истории содержит дубликаты.");
    }
    @Test
    void DeleteElementHistory() {
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Task task1 = new Task("Task 1", "Task description");
        manager.addTask(task1);
        Task task2 = new Task("Task 2", "Yes");
        manager.addTask(task2);
        Task task3 = new Task("Task 3", "No");
        manager.addTask(task3);
        imhm.add(task1);
        imhm.add(task2);
        imhm.add(task3);
        ArrayList<Task> history = imhm.getHistoryForBack();//проверка что 3 эл в истории
        assertEquals(3, history.size(), "История должна содержать 3 задачи.");
        imhm.remove(task1.id);
        history = imhm.getHistoryForBack();//проверка что 2 эл в истории и нету первого
        assertEquals(2, history.size(), "История должна содержать 2 задачи после удаления первой.");
        assertFalse(history.contains(task1), "История не должна содержать первую задачу после удаления.");
        imhm.add(task1);
        history = imhm.getHistoryForBack();//проверка что 3 эл в истории
        assertEquals(3, history.size(), "История должна содержать 3 задачи.");
        imhm.remove(task2.id);
        history = imhm.getHistoryForBack();//проверка что 2 эл в истории и нету средного
        assertEquals(2, history.size(), "История должна содержать 2 задачи после удаления второй.");
        assertFalse(history.contains(task2), "История не должна содержать вторую задачу после удаления.");
        imhm.add(task2);
        history = imhm.getHistoryForBack();//проверка что 3 эл в истории
        assertEquals(3, history.size(), "История должна содержать 3 задачи.");
        imhm.remove(task3.id);
        history = imhm.getHistoryForBack();//проверка что 2 эл в истории и нету средного
        assertEquals(2, history.size(), "История должна содержать 2 задачи после удаления третьего.");
        assertFalse(history.contains(task3), "История не должна содержать третью задачу после удаления.");

    }
}