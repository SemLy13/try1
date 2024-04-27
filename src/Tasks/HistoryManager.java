package Tasks;

import java.util.LinkedList;

interface HistoryManager {
    void add(Task task);
    void remove(String id);
    void getHistory();
}
