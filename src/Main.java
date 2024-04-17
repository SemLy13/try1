import Tasks.Task;
import Tasks.Subtask;
import Tasks.Epic;
import Tasks.InMemoryTaskManager;
import Tasks.InMemoryHistoryManager;
import Tasks.Managers;


public class Main {

    public static void ExampleData(){
        Task task = new Task("Task name", "Task description");
        InMemoryTaskManager InMemoryTaskManager = new InMemoryTaskManager();
        InMemoryTaskManager.addTask(task.id, task);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Task task2 = new Task("Work", "Yes");
        InMemoryTaskManager.addTask(task2.id, task2);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Task task3 = new Task("TQWE", "dfgh", Task.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateTask(task.id, task3);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
//        manager.GetTask(task2.id);
//        manager.RemoveTask(task.id);
//        System.out.println();
//        manager.PrintAll();
//        manager.RemoveAll();

        // InMemoryTaskManager InMemoryTaskManager = new InMemoryTaskManager();
        Epic epic = new Epic("Task name", "Task description");
        InMemoryTaskManager.addEpic(epic.id, epic);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub = new Subtask(epic.id, "first", "descr");
        InMemoryTaskManager.addSubTask(sub.id, sub);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub3 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateSubtask(sub.id, sub3);//UpdateSubtask
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub2 = new Subtask(epic.id, "second", "descr");
        InMemoryTaskManager.addSubTask(sub2.id, sub2);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub4 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.DONE);
        InMemoryTaskManager.UpdateSubtask(sub.id, sub4);
        Subtask sub5 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateSubtask(sub2.id, sub5);
        InMemoryTaskManager.PrintAll();
        //System.out.println("=============");
        //manager.MySubtasks(epic);

        InMemoryHistoryManager historyManager = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager.GetSubtask(sub5.id);
        InMemoryTaskManager.GetSubtask(sub4.id);
        InMemoryTaskManager.GetSubtask(sub3.id);
        InMemoryTaskManager.GetSubtask(sub2.id);
        InMemoryTaskManager.GetSubtask(sub.id);
        InMemoryTaskManager.GetEpic(epic.id);
        InMemoryTaskManager.GetTask(task.id);
        InMemoryTaskManager.GetTask(task2.id);
        //InMemoryTaskManager.GetTask(task3.id);
        InMemoryTaskManager.GetEpic(epic.id);
        InMemoryTaskManager.GetTask(task.id);
        InMemoryTaskManager.GetTask(task2.id);
        System.out.println("=============");
        historyManager.getHistory();
    }
    public static void main(String[] args) {
        //ExampleData();
        InMemoryTaskManager InMemoryTaskManager = new InMemoryTaskManager();

        Task task = new Task("Task 1", "Task description");
        InMemoryTaskManager.addTask(task.id, task);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Task task2 = new Task("Task 2", "Yes");
        InMemoryTaskManager.addTask(task2.id, task2);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Task task3 = new Task("Task 3", "dfgh", Task.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateTask(task.id, task3);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");

        Epic epic = new Epic("epic", "Task description");
        InMemoryTaskManager.addEpic(epic.id, epic);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub = new Subtask(epic.id, "Sub 1", "descr");
        InMemoryTaskManager.addSubTask(sub.id, sub);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub3 = new Subtask(epic.id, "Sub 3", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateSubtask(sub.id, sub3);//UpdateSubtask
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub2 = new Subtask(epic.id, "Sub 2", "descr");
        InMemoryTaskManager.addSubTask(sub2.id, sub2);
        InMemoryTaskManager.PrintAll();
        System.out.println("=============");
        Subtask sub4 = new Subtask(epic.id, "Sub 4", "!!!!!!!", Subtask.Status.DONE);
        InMemoryTaskManager.UpdateSubtask(sub.id, sub4);
        Subtask sub5 = new Subtask(epic.id, "Sub 5", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        InMemoryTaskManager.UpdateSubtask(sub2.id, sub5);
        InMemoryTaskManager.PrintAll();
        //System.out.println("=============");
        //manager.MySubtasks(epic);

        InMemoryHistoryManager historyManager = (InMemoryHistoryManager) Managers.getDefaultHistory();
        InMemoryTaskManager.GetSubtask(sub5.id);
        InMemoryTaskManager.GetSubtask(sub4.id);
        InMemoryTaskManager.GetSubtask(sub3.id);
        InMemoryTaskManager.GetSubtask(sub2.id);
        InMemoryTaskManager.GetSubtask(sub.id);
        InMemoryTaskManager.GetEpic(epic.id);
        InMemoryTaskManager.GetTask(task.id);
        InMemoryTaskManager.GetTask(task2.id);
        //InMemoryTaskManager.GetTask(task3.id);
        InMemoryTaskManager.GetEpic(epic.id);
        InMemoryTaskManager.GetTask(task.id);
        InMemoryTaskManager.GetTask(task2.id);
        System.out.println("=============");
        historyManager.getHistory();

    }
}