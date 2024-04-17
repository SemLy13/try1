package Tasks;

import java.util.LinkedList;

public class InMemoryHistoryManager implements HistoryManager{
    private static LinkedList<Task> List;
    private final int MAX_SIZE = 10;
    public InMemoryHistoryManager() {
        List = new LinkedList<>();
    }
    @Override
    public void add(Task task){
        if (List.size() >= MAX_SIZE) {
            List.removeLast();
        }
        List.addFirst(task);
    }
    @Override
    public LinkedList<Task> getHistory(){
        PrintAll(List);
        return List;
    }
    public void PrintAll(LinkedList<Task> l) {
        for (Task task : l) {
            System.out.println(task.name);
        }
    }
}
