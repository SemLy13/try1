package Tasks;

import java.util.UUID;

public class Task {
    public String name,description,id;
    public Status status = Status.NEW;
    public enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }
    public Task(String name, String description){
        this.name = name;
        this.description = description;
        id = ID();
    }
    public Task(String name, String description, Status status){
        this.name = name;
        this.description = description;
        id = ID();
        this.status = status;
    }
    public static String ID(){
        //String uniqueID = UUID.randomUUID().toString();
        return UUID.randomUUID().toString();
    }

    // class manager -> interface manager
    // новый класс InMemoryTaskManager, перенести туда всё из Manager +
    // class InMemoryTaskManager implements TaskManager (@Override)
    // новая фича: метод .history() , если вызывается метод GetTask,Epic,Subtask
}
