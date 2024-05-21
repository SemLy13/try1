import Tasks.*;
import java.time.LocalDateTime;

public class Main {

//    public static void ExampleData(){
//        Task task = new Task("Task name", "Task description");
//        InMemoryTaskManager InMemoryTaskManager = new InMemoryTaskManager();
//        InMemoryTaskManager.addTask(task.id, task);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Task task2 = new Task("Work", "Yes");
//        InMemoryTaskManager.addTask(task2.id, task2);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Task task3 = new Task("TQWE", "dfgh", Task.Status.IN_PROGRESS);
//        InMemoryTaskManager.UpdateTask(task.id, task3);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
////        manager.GetTask(task2.id);
////        manager.RemoveTask(task.id);
////        System.out.println();
////        manager.PrintAll();
////        manager.RemoveAll();
//
//        // InMemoryTaskManager InMemoryTaskManager = new InMemoryTaskManager();
//        Epic epic = new Epic("Task name", "Task description");
//        InMemoryTaskManager.addEpic(epic.id, epic);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Subtask sub = new Subtask(epic.id, "first", "descr");
//        InMemoryTaskManager.addSubTask(sub.id, sub);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Subtask sub3 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
//        InMemoryTaskManager.UpdateSubtask(sub.id, sub3);//UpdateSubtask
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Subtask sub2 = new Subtask(epic.id, "second", "descr");
//        InMemoryTaskManager.addSubTask(sub2.id, sub2);
//        InMemoryTaskManager.PrintAll();
//        System.out.println("=============");
//        Subtask sub4 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.DONE);
//        InMemoryTaskManager.UpdateSubtask(sub.id, sub4);
//        Subtask sub5 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
//        InMemoryTaskManager.UpdateSubtask(sub2.id, sub5);
//        InMemoryTaskManager.PrintAll();
//        //System.out.println("=============");
//        //manager.MySubtasks(epic);
//
//        InMemoryHistoryManager historyManager = (InMemoryHistoryManager) Managers.getDefaultHistory();
//        InMemoryTaskManager.GetSubtask(sub5.id);
//        InMemoryTaskManager.GetSubtask(sub4.id);
//        InMemoryTaskManager.GetSubtask(sub3.id);
//        InMemoryTaskManager.GetSubtask(sub2.id);
//        InMemoryTaskManager.GetSubtask(sub.id);
//        InMemoryTaskManager.GetEpic(epic.id);
//        InMemoryTaskManager.GetTask(task.id);
//        InMemoryTaskManager.GetTask(task2.id);
//        //InMemoryTaskManager.GetTask(task3.id);
//        InMemoryTaskManager.GetEpic(epic.id);
//        InMemoryTaskManager.GetTask(task.id);
//        InMemoryTaskManager.GetTask(task2.id);
//        System.out.println("=============");
//        historyManager.getHistory();
//    }
    public static void main(String[] args) {
        //ExampleData();
        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);

        //LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime startTime = LocalDateTime.of(2024, 1, 1, 12, 0);
        Task task = new Task("Task 1", "No",120, startTime);
        manager.addTask(task);
        System.out.println(manager.DefaultTasks.get(task.id).getEndTime());
        Task task2 = new Task("Task 2", "Yes",90, LocalDateTime.of(2024, 1, 1, 14, 0));
        manager.addTask(task2);
        System.out.println(manager.DefaultTasks.get(task2.id).getEndTime());
        Epic epic = new Epic("epic 1", "Task description",0, LocalDateTime.of(2024, 1, 1, 10, 0));
        manager.addEpic(epic);
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr",10, LocalDateTime.of(2024, 1, 1, 11, 30));
        manager.addSubTask(sub);
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!",2, startTime);
        manager.addSubTask(sub2);
        Subtask sub3 = new Subtask(epic.id, "Sub 3", "descr",3, startTime);
        manager.addSubTask(sub3);
        Epic epic2 = new Epic("epic 2", "Task description", 0 , LocalDateTime.of(2024, 1, 1, 11, 0));
        manager.addEpic(epic2);
        System.out.println(manager.EpicTasks.get(epic.id).getEndTime());
        System.out.println(manager.EpicTasks.get(epic2.id).getEndTime());
        manager.PrintAll();
        System.out.println("=============");
        manager.printPrioritizedTasks();
//        manager.GetSubtask(sub3.id);
//        manager.GetSubtask(sub2.id);
//        manager.GetSubtask(sub.id);
//        manager.GetEpic(epic.id);
//        manager.GetTask(task.id);
//        manager.GetEpic(epic2.id);
//        manager.GetTask(task2.id);
//        //InMemoryTaskManager.GetTask(task3.id);
//        manager.GetEpic(epic.id);
//        manager.GetTask(task.id);
//        manager.GetTask(task2.id);
//        manager.GetSubtask(sub3.id);
//        manager.GetSubtask(sub2.id);
//        manager.GetSubtask(sub.id);
//        manager.GetEpic(epic.id);
//        System.out.println("=============////");
//        imhm.getHistory();
//        imhm.remove(epic.id);
//        System.out.println("=============////");
//        imhm.getHistory();
    }
}