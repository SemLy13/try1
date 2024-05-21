package Tasks;

import java.util.UUID;
import java.time.LocalDateTime;

public class Task {
    public String name,description,id;
    public Status status;
    public enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }
    public long duration = 0; // продолжительность в минутах
    public LocalDateTime startTime; // время начала
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
    public Task(String name, String description, long duration, LocalDateTime startTime){
        this.name = name;
        this.description = description;
        id = ID();
        status = Status.NEW;
        this.duration = duration;
        this.startTime = startTime;
    }
    public static String ID(){
        return UUID.randomUUID().toString();
    }
    public LocalDateTime getEndTime() {
        if (startTime != null) {
            return startTime.plusMinutes(duration);
        }
        return null;
    }
}
