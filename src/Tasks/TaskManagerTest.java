package Tasks;

import Tasks.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class TaskManagerTest<T extends TaskManager> {

    protected T manager;
    protected abstract T createTaskManager();
    @Test
    void testAddTask() {
        manager = createTaskManager();
        Task task = new Task("Task 1", "Task description", Task.Status.NEW);
        manager.addTask(task);
        assertNotNull(manager.getTask(task.id), "Задача должна быть добавлена.");
    }
}
