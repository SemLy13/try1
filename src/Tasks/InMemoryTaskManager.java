package Tasks;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    public HashMap<String, Task> DefaultTasks;
    public HashMap<String, Epic> EpicTasks;
    public HashMap<String, Subtask> SubTasks;
    private InMemoryHistoryManager imht;
    public InMemoryTaskManager(){
        DefaultTasks  = new HashMap<>();
        EpicTasks  = new HashMap<>();
        SubTasks  = new HashMap<>();
        imht = new InMemoryHistoryManager();
    }
    @Override
    public void addTask(String id, Task task){
        DefaultTasks.put(id, task);
    }
    @Override
    public void addEpic(String id, Epic epic){
        EpicTasks.put(id, epic);
    }
    @Override
    public void addSubTask(String id, Subtask subtask){
        SubTasks.put(id, subtask);
        EpicTasks.get(subtask.EpicId).SubTasksForEpic.put(id, subtask);
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
                    + entry.getValue().description + "  Status: " + entry.getValue().status);
        }
        System.out.println();
        System.out.println("Type : Epic Tasks");
        for (Map.Entry<String, Epic> entry : EpicTasks.entrySet()) {
            System.out.println("ID: "+ entry.getKey() + "  NAME: " + entry.getValue().name + "  Task Description: "
                    + entry.getValue().description + "  Status: " + entry.getValue().status);
        }
        System.out.println();
        System.out.println("Type : Sub Tasks");
        for (Map.Entry<String, Subtask> entry : SubTasks.entrySet()) {
            System.out.println("ID: "+ entry.getKey() + " Epic ID "+ entry.getValue().EpicId+  "  NAME: " + entry.getValue().name + "  Task Description: "
                    + entry.getValue().description + "  Status: " + entry.getValue().status);
        }
        System.out.println();
    }
    @Override
    public void GetTask(String id){
        //DefaultTasks.get(id);
        System.out.println("ID: "+ DefaultTasks.get(id).id + "  NAME: " + DefaultTasks.get(id).name
                + "  Task Description: " + DefaultTasks.get(id).description + "  Status: "
                + DefaultTasks.get(id).status);
        //InMemoryHistoryManager imht = new InMemoryHistoryManager();
        imht.add(DefaultTasks.get(id));

    }
    @Override
    public void GetEpic(String id){
        //EpicTasks.get(id)
        System.out.println("ID: "+ EpicTasks.get(id).id + "  NAME: " + EpicTasks.get(id).name
                + "  Task Description: " + EpicTasks.get(id).description + "  Status: "
                + EpicTasks.get(id).status);
       // InMemoryHistoryManager imht = new InMemoryHistoryManager();
        imht.add(EpicTasks.get(id));
    }
    @Override
    public void GetSubtask(String id){
        //SubTasks.get(id)
        System.out.println("ID: "+ SubTasks.get(id).id + " Epic ID "+ SubTasks.get(id).EpicId +
                "  NAME: " + SubTasks.get(id).name +
                "  Task Description: " + SubTasks.get(id).description + "  Status: " +
                SubTasks.get(id).status);
       // InMemoryHistoryManager imht = new InMemoryHistoryManager();
        imht.add(SubTasks.get(id));
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
}
