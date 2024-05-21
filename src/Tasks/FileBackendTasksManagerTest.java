package Tasks;

public class FileBackendTasksManagerTest extends TaskManagerTest<FileBackendTasksManager> {
    @Override
    protected FileBackendTasksManager createTaskManager() {
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        return new FileBackendTasksManager(imhm);
    }
}
