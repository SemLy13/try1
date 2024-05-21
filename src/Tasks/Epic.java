package Tasks;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    public HashMap<String, Subtask> SubTasksForEpic;
    public LocalDateTime endTime;
    public Epic(String name, String description) {
        super(name, description);
        SubTasksForEpic = new HashMap<>();
    }
    public Epic(String id,String name, String description, Status status) {
        super(id, name, description, status);
        SubTasksForEpic = new HashMap<>();
    }
    public Epic(String name, String description, long duration, LocalDateTime startTime){
        super(name, description, duration, startTime);
        SubTasksForEpic = new HashMap<>();
    }
    @Override
    public LocalDateTime getEndTime() {
        if (startTime != null) {
            long totalDuration = 0;
            for (Subtask subtask : SubTasksForEpic.values()) {
                totalDuration += subtask.duration;
            }
            return startTime.plusMinutes(totalDuration);
        }
        return null;
    }
    public void PrintSub(){
        System.out.println(SubTasksForEpic);
        System.out.println(SubTasksForEpic.size());
    }
    public void CheckStatus(){
        int size = SubTasksForEpic.size();
        int c = size * 2;
        for (Map.Entry<String, Subtask> entry : SubTasksForEpic.entrySet()) {
           // System.out.println("!!!!!!!!" + entry.getValue().status);/////
        if (entry.getValue().status == Status.DONE){ c = c - 2;}
        if (entry.getValue().status == Status.IN_PROGRESS){ c--;}
        }
        if (c == 0){
            status = Status.DONE;
        } else if ((c > 0) && (c < size * 2)) {
            status = Status.IN_PROGRESS;
        }
    }
}
