package Tasks;

import java.util.UUID;

public class Task {
    public String name,description,id;
    public Status status;
    public enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }
    public Task(String name, String description){
        this.name = name;
        this.description = description;
        id = ID();
        status = Status.NEW;
    }
    public Task(String name, String description, Status status){
        this.name = name;
        this.description = description;
        id = ID();
        this.status = status;
    }
    public Task(String id,String name, String description, Status status){
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = status;
    }
    public static String ID(){
        //String uniqueID = UUID.randomUUID().toString();
        return UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    return id;
    }
}
