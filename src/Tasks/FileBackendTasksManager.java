package Tasks;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.ArrayList;
public class FileBackendTasksManager extends InMemoryTaskManager{
    private File file = new File("C:\\Users\\SemLy\\Documents\\dev\\tasks1\\try1\\src\\Tasks\\data.csv");
    public FileBackendTasksManager(InMemoryHistoryManager imhm){
        super(imhm);
        //this.file = file;
        readFromFile();
    }
    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean readingTasks = true;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    readingTasks = false;
                    continue;
                }
                if (readingTasks) {
                    fromStringToTask(line);
                } else {
                    fromStringToHistory(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fromStringToTask(String value){//чтение задачи из файла
        String[] parts = value.split(", ");
        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid CSV string form: " + value);
        }
        String id = parts[0].trim();
        String type = parts[1].trim();
        String name = parts[2].trim();
        String statusStr = parts[3].trim();
        String description = parts[4].trim();
        String epicId = "";
        if (parts.length > 5) {
            epicId = parts[5].trim();
        }

        Task.Status status = Task.Status.valueOf(statusStr);
        switch (type) {
            case "TASK":
                Task task = new Task(id, name, description, status);
                addTask(task);
                break;
            case "EPIC":
                Epic epicTask = new Epic(id, name, description, status);
                addEpic(epicTask);
                break;
            case "SUBTASK":
                Subtask subtask = new Subtask(epicId, id, name, description, status);
                addSubTask(subtask);
                break;
            default:
                System.out.println("Unknown task type: " + type);
                break;
        }
    }
    public void fromStringToHistory(String line) {
        String[] parts = line.split(", ");
        for (int i = 0; i < parts.length; i++) {
            String id = parts[i].trim(); // Получаем ID элемента
            if (DefaultTasks.containsKey(id)) {
                imhm.add(DefaultTasks.get(id));
            } else if (EpicTasks.containsKey(id)) {
                imhm.add(EpicTasks.get(id));
            } else if (SubTasks.containsKey(id)) {
                imhm.add(SubTasks.get(id));
            } else {
                System.out.println("Element with ID " + id + " not found!");
            }
        }
    }
//    static String toString(HistoryManager manager){//сохранение задачи в файла
//
//    }
//    static List<String> fromString(String value){
//
//    }
//    static FileBackendTasksManager loadFromFile(File file){
//
//    }
    @Override
    public void addTask(Task task){
        DefaultTasks.put(task.id, task);
        save();
    }
    @Override
    public void addEpic(Epic epic){
        EpicTasks.put(epic.id, epic);
        save();
    }
    @Override
    public void addSubTask(Subtask subtask){
        SubTasks.put(subtask.id, subtask);
        EpicTasks.get(subtask.EpicId).SubTasksForEpic.put(subtask.id, subtask);
        EpicTasks.get(subtask.EpicId).CheckStatus();
        save();
    }
    @Override
    public void UpdateTask(String id, Task task){
        DefaultTasks.put(id, task);
        save();
    }
    @Override
    public void UpdateSubtask(String id, Subtask subtask){
        subtask.id = id;
        SubTasks.put(id, subtask);
        EpicTasks.get(subtask.EpicId).SubTasksForEpic.put(id, subtask);
        EpicTasks.get(subtask.EpicId).CheckStatus();
        save();
    }
    @Override
    public void GetTask(String id){
        //DefaultTasks.get(id);
        System.out.println("ID: "+ DefaultTasks.get(id).id + "  NAME: " + DefaultTasks.get(id).name
                + "  Task Description: " + DefaultTasks.get(id).description + "  Status: "
                + DefaultTasks.get(id).status);
        imhm.add(DefaultTasks.get(id));
        save();
    }
    @Override
    public void GetEpic(String id){
        //EpicTasks.get(id)
        System.out.println("ID: "+ EpicTasks.get(id).id + "  NAME: " + EpicTasks.get(id).name
                + "  Task Description: " + EpicTasks.get(id).description + "  Status: "
                + EpicTasks.get(id).status);
        imhm.add(EpicTasks.get(id));
        save();
    }
    @Override
    public void GetSubtask(String id){
        //SubTasks.get(id)
        System.out.println("ID: "+ SubTasks.get(id).id + " Epic ID "+ SubTasks.get(id).EpicId +
                "  NAME: " + SubTasks.get(id).name +
                "  Task Description: " + SubTasks.get(id).description + "  Status: " +
                SubTasks.get(id).status);
        imhm.add(SubTasks.get(id));
        save();
    }
    @Override
    public void RemoveTask(String id){
        DefaultTasks.remove(id);
        save();
    }
    @Override
    public void RemoveEpic(String id){
        EpicTasks.remove(id);
        save();
    }
    @Override
    public void RemoveSubtask(String id){
        SubTasks.remove(id);
        save();
    }
    @Override
    public void RemoveAllTask(){
        DefaultTasks.clear();
        save();
    }
    @Override
    public void RemoveAllEpic(){
        EpicTasks.clear();
        save();
    }
    @Override
    public void RemoveAllSubtask(){
        SubTasks.clear();
        save();
    }
    @Override
    public void RemoveAll(){
        DefaultTasks.clear();
        EpicTasks.clear();
        SubTasks.clear();
        save();
    }
    protected void save(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\SemLy\\Documents\\dev\\tasks1\\try1\\src\\Tasks\\data.csv"))) {
            writer.write("");
            for (Map.Entry<String, Task> entry : DefaultTasks.entrySet()) {
                writer.write(entry.getValue().id + ", TASK, " + entry.getValue().name + ", " +
                        entry.getValue().status + ", " + entry.getValue().description  + "\n");
            }
            for (Map.Entry<String, Epic> entry : EpicTasks.entrySet()) {
                writer.write(entry.getValue().id + ", EPIC, " + entry.getValue().name + ", " +
                        entry.getValue().status + ", " + entry.getValue().description +"\n");
            }
            for (Map.Entry<String, Subtask> entry : SubTasks.entrySet()) {
                writer.write(entry.getValue().id + ", SUBTASK, " + entry.getValue().name + ", " +
                        entry.getValue().status + ", " + entry.getValue().description + ", " + entry.getValue().EpicId +"\n");
            }
            writer.write("\n");
            ArrayList<Task> history = imhm.getHistoryForBack();
            for (Task task: history){
                writer.write(task.toString() + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        FileBackendTasksManager fbtm = new FileBackendTasksManager(imhm);
        fbtm.PrintAll();
        System.out.println("=============");
        Task task = new Task("Task 1", "Task description");
        fbtm.addTask(task);
        fbtm.PrintAll();
        fbtm.GetTask(task.id);
    }
}

