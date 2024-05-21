package Tasks;

public class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {

    @Override
    protected InMemoryTaskManager createTaskManager() {
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        return new InMemoryTaskManager(imhm);
    }
}
