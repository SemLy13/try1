package Tasks;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{
    private Node first;
    private Node last;
    private HashMap<String, Node> taskMap;
    ArrayList<Task> tasks;
    private static LinkedList<Task> List;
    private final int MAX_SIZE = 10;
    public InMemoryHistoryManager() {
        //List = new LinkedList<>();
        taskMap = new HashMap<>();
        tasks = new ArrayList<>();
    }
/*    @Override
    public void add(Task task){
        if (List.size() >= MAX_SIZE) {
            List.removeLast();
        }
        List.addFirst(task);
    }*/
public void linkLast(Task task) {
    Node newNode = new Node(task);
    if (last == null) {
        first = newNode;
        last = newNode;
    } else {
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }
    taskMap.put(task.id, newNode);
}

    public ArrayList<Task> getTasks() {
        //ArrayList<Task> tasks = new ArrayList<>();
        Node current = first;
        while (current != null) {
            tasks.add(current.task);
            current = current.next;
        }
        return tasks;
    }

    public void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            first = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }
        taskMap.remove(node.task.id);
    }

    public void add(Task task) {
        if (taskMap.containsKey(task.id)) {
            Node existingNode = taskMap.get(task.id);
            removeNode(existingNode);
        }
        linkLast(task);
    }

    @Override
    public void remove(String id) {
        if (taskMap.containsKey(id)) {
            Task taskToRemove = taskMap.get(id).task; // Получаем задачу по id
            if (taskToRemove instanceof Epic) {
                HashMap<String, Subtask> subtasks = ((Epic) taskToRemove).SubTasksForEpic;
                for (Subtask subtask : subtasks.values()) {
                    remove(subtask.id); // Рекурсивно удаляем подзадачу
                }
            }
            taskMap.remove(id);
            tasks.clear();
            for (Node node : taskMap.values()) {
                tasks.add(node.task);
            }
        }
    }



    @Override
    public void getHistory() {
        tasks.clear(); // Очищаем список перед заполнением
        for (Node node : taskMap.values()) {
            tasks.add(node.task);
        }
        PrintAll(tasks);
    }

    public void PrintAll(LinkedList<Task> l) {
        for (Task task : l) {
            System.out.println(task.name);
        }
    }
    public void PrintAll(ArrayList<Task> a){
        for (Task task : a) {
            System.out.println(task.name + ": " + task.id);
        }
    }
}
