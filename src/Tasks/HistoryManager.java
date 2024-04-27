package Tasks;

interface HistoryManager {
    void add(Task task);
    void remove(String id);
    void getHistory();
}
