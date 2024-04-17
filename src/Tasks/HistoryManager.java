package Tasks;

import java.util.LinkedList;

interface HistoryManager {
    void add(Task task);
    LinkedList<Task> getHistory();
}
