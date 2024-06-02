package Tasks;

public class Managers {
    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
    public static FileBackendTasksManager getDefaultFBTM(){
        return new FileBackendTasksManager(new InMemoryHistoryManager());
    }
}
