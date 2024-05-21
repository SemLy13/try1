package Tasks;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTaskManager implements TaskManager {
    public HashMap<String, Task> DefaultTasks;
    public HashMap<String, Epic> EpicTasks;
    public HashMap<String, Subtask> SubTasks;
    public InMemoryHistoryManager imhm;
    public InMemoryTaskManager(InMemoryHistoryManager imhm){
        DefaultTasks  = new HashMap<>();
        EpicTasks  = new HashMap<>();
        SubTasks  = new HashMap<>();
        this.imhm = imhm;
    }
    public List<Task> getPrioritizedTasks() {
        List<Task> allTasks = new ArrayList<>();

        // Собираем все задачи, эпики и подзадачи в один список
        allTasks.addAll(DefaultTasks.values());
        allTasks.addAll(EpicTasks.values());
        allTasks.addAll(SubTasks.values());

        // Сортируем задачи по startTime, если поле отсутствует, задача идет в конец списка
        return allTasks.stream()
                .sorted(Comparator.comparing((Task t) -> t.startTime != null ? t.startTime : LocalDateTime.MAX))
                .collect(Collectors.toList());
    }

    public void printPrioritizedTasks() {
        List<Task> prioritizedTasks = getPrioritizedTasks();
        for (Task task : prioritizedTasks) {
            System.out.println(task.name);
        }
    }
    @Override
    public void addTask(Task task){
        DefaultTasks.put(task.id, task);
    }
    @Override
    public void addEpic(Epic epic){
        EpicTasks.put(epic.id, epic);
    }
    @Override
    public void addSubTask(Subtask subtask){
        SubTasks.put(subtask.id, subtask);
        EpicTasks.get(subtask.EpicId).SubTasksForEpic.put(subtask.id, subtask);
        EpicTasks.get(subtask.EpicId).CheckStatus();
    }
    @Override
    public void UpdateTask(String id, Task task){
        DefaultTasks.put(id, task);
    }
    @Override
    public void UpdateSubtask(String id, Subtask subtask){
        subtask.id = id;
        SubTasks.put(id, subtask);
        EpicTasks.get(subtask.EpicId).SubTasksForEpic.put(id, subtask);
        EpicTasks.get(subtask.EpicId).CheckStatus();
    }
    @Override
    public void PrintAll() {
        System.out.println("Type : Default Tasks");
        for (Map.Entry<String, Task> entry : DefaultTasks.entrySet()) {
            System.out.println("ID: "+ entry.getKey() + "  NAME: " + entry.getValue().name + "  Task Description: "
                    + entry.getValue().description + "  Status: " + entry.getValue().status + " Duration: "
                    + entry.getValue().duration + " StartTime: " + entry.getValue().startTime);
        }
        System.out.println();
        System.out.println("Type : Epic Tasks");
        for (Map.Entry<String, Epic> entry : EpicTasks.entrySet()) {
            System.out.println("ID: "+ entry.getKey() + "  NAME: " + entry.getValue().name + "  Task Description: "
                    + entry.getValue().description + "  Status: " + entry.getValue().status + " Duration: "
                    + entry.getValue().duration + " StartTime: " + entry.getValue().startTime);
        }
        System.out.println();
        System.out.println("Type : Sub Tasks");
        for (Map.Entry<String, Subtask> entry : SubTasks.entrySet()) {
            System.out.println("ID: "+ entry.getKey() + " Epic ID "+ entry.getValue().EpicId+  "  NAME: "
                    + entry.getValue().name + "  Task Description: " + entry.getValue().description + "  Status: "
                    + entry.getValue().status + " Duration: " + entry.getValue().duration + " StartTime: "
                    + entry.getValue().startTime);
        }
        System.out.println();
    }
    @Override
    public void GetTask(String id){
//        DefaultTasks.get(id);
        System.out.println("ID: "+ DefaultTasks.get(id).id + "  NAME: " + DefaultTasks.get(id).name
                + "  Task Description: " + DefaultTasks.get(id).description + "  Status: "
                + DefaultTasks.get(id).status);
        imhm.add(DefaultTasks.get(id));
    }
    @Override
    public void GetEpic(String id){
        //EpicTasks.get(id);
        System.out.println("ID: "+ EpicTasks.get(id).id + "  NAME: " + EpicTasks.get(id).name
                + "  Task Description: " + EpicTasks.get(id).description + "  Status: "
                + EpicTasks.get(id).status);
        imhm.add(EpicTasks.get(id));
    }
    @Override
    public void GetSubtask(String id){
        //SubTasks.get(id)
        System.out.println("ID: "+ SubTasks.get(id).id + " Epic ID "+ SubTasks.get(id).EpicId +
                "  NAME: " + SubTasks.get(id).name +
                "  Task Description: " + SubTasks.get(id).description + "  Status: " +
                SubTasks.get(id).status);
        imhm.add(SubTasks.get(id));
    }
    @Override
    public void MySubtasks(Epic epic){
        epic.PrintSub();
    }
    @Override
    public void RemoveTask(String id){
        DefaultTasks.remove(id);
    }
    @Override
    public void RemoveEpic(String id){
        EpicTasks.remove(id);
    }
    @Override
    public void RemoveSubtask(String id){
        SubTasks.remove(id);
    }
    @Override
    public void RemoveAllTask(){
        DefaultTasks.clear();
    }
    @Override
    public void RemoveAllEpic(){
        EpicTasks.clear();
    }
    @Override
    public void RemoveAllSubtask(){
        SubTasks.clear();
    }
    @Override
    public void RemoveAll(){
        DefaultTasks.clear();
        EpicTasks.clear();
        SubTasks.clear();
    }
    @Override
    public Task getTask(String id){
        return DefaultTasks.get(id);
    }
}
