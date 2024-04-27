package Tasks;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    //public String id;
   // public Status status;
    public HashMap<String, Subtask> SubTasksForEpic;
    public Epic(String name, String description) {
        super(name, description);
        SubTasksForEpic = new HashMap<>();
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
