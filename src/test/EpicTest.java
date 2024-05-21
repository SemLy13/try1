package test;

import Tasks.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    @Test
    void EmptySubtask(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Epic epic = new Epic("epic 1", "Task description");
        manager.addEpic(epic);
        HashMap<String, Subtask> subTasks = epic.SubTasksForEpic;
        assertNotNull(subTasks, "Список подзадач не должен быть null.");
        assertTrue(subTasks.isEmpty(), "Список подзадач должен быть пустым.");
    }
    @Test
    void AllSubTasksStatusNew(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Epic epic = new Epic("epic 1", "Task description");
        manager.addEpic(epic);
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr");
        manager.addSubTask(sub);
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!");
        manager.addSubTask(sub2);
        HashMap<String, Subtask> subTasks = epic.SubTasksForEpic;
        for (Subtask subtask : subTasks.values()) {
            assertEquals(Task.Status.NEW, subtask.status, "Статус подзадачи должен быть Status.NEW.");
        }
        assertEquals(Task.Status.NEW, epic.status, "Статус эпика должен быть Status.NEW.");
    }
    @Test
    void AllSubTasksStatusDone(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Epic epic = new Epic("epic 1", "Task description");
        manager.addEpic(epic);
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr", Task.Status.DONE);
        manager.addSubTask(sub);
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!", Task.Status.DONE);
        manager.addSubTask(sub2);
        HashMap<String, Subtask> subTasks = epic.SubTasksForEpic;
        for (Subtask subtask : subTasks.values()) {
            assertEquals(Task.Status.DONE, subtask.status, "Статус подзадачи должен быть Status.Done.");
        }
        assertEquals(Task.Status.DONE, epic.status, "Статус эпика должен быть Status.Done.");
    }
    @Test
    void AllSubTasksStatusInProgress(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Epic epic = new Epic("epic 1", "Task description");
        manager.addEpic(epic);
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr", Task.Status.IN_PROGRESS);
        manager.addSubTask(sub);
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!", Task.Status.IN_PROGRESS);
        manager.addSubTask(sub2);
        HashMap<String, Subtask> subTasks = epic.SubTasksForEpic;
        for (Subtask subtask : subTasks.values()) {
            assertEquals(Task.Status.IN_PROGRESS, subtask.status, "Статус подзадачи должен быть Status.IN_PROGRESS.");
        }
        assertEquals(Task.Status.IN_PROGRESS, epic.status, "Статус эпика должен быть Status.IN_PROGRESS.");
    }
    @Test
    void SubTasksStatusNewAndDone(){
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
        Epic epic = new Epic("epic 1", "Task description");
        manager.addEpic(epic);
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr");
        manager.addSubTask(sub);
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!", Task.Status.DONE);
        manager.addSubTask(sub2);
        HashMap<String, Subtask> subTasks = epic.SubTasksForEpic;
        for (Subtask subtask : subTasks.values()) {
            assertTrue(subtask.status == Task.Status.NEW || subtask.status == Task.Status.DONE, "Статус подзадачи должен быть NEW или DONE.");
        }
        assertEquals(Task.Status.IN_PROGRESS, epic.status, "Статус эпика должен быть Status.IN_PROGRESS.");
    }
}