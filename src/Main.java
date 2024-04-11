import Tasks.Task;
import Tasks.Subtask;
import Tasks.Epic;
import Tasks.Manager;



public class Main {

    public static void ExampleData(){
        Task task = new Task("Task name", "Task description");
        Manager manager = new Manager();
        manager.addTask(task.id, task);
        manager.PrintAll();
        System.out.println("=============");
        Task task2 = new Task("Work", "Yes");
        manager.addTask(task2.id, task2);
        manager.PrintAll();
        System.out.println("=============");
        Task task3 = new Task("TQWE", "dfgh", Task.Status.IN_PROGRESS);
        manager.UpdateTask(task.id, task3);
        manager.PrintAll();
        System.out.println("=============");
//        manager.GetTask(task2.id);
//        manager.RemoveTask(task.id);
//        System.out.println();
//        manager.PrintAll();
//        manager.RemoveAll();

//        Epic epic = new Epic("Task name", "Task description");
//        manager.addEpic(epic.id, epic);
//        manager.PrintAll();
    }
    public static void main(String[] args) {
        ExampleData();
        Manager manager = new Manager();
        Epic epic = new Epic("Task name", "Task description");
        manager.addEpic(epic.id, epic);
        manager.PrintAll();
        System.out.println("=============");
        Subtask sub = new Subtask(epic.id, "first", "descr");
        manager.addSubTask(sub.id, sub);
        manager.PrintAll();
        System.out.println("=============");
        Subtask sub3 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        manager.UpdateSubtask(sub.id, sub3);//UpdateSubtask
        manager.PrintAll();
        System.out.println("=============");
        Subtask sub2 = new Subtask(epic.id, "second", "descr");
        manager.addSubTask(sub2.id, sub2);
        manager.PrintAll();
        System.out.println("=============");
        Subtask sub4 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.DONE);
        manager.UpdateSubtask(sub.id, sub4);
        Subtask sub5 = new Subtask(epic.id, "first", "!!!!!!!", Subtask.Status.IN_PROGRESS);
        manager.UpdateSubtask(sub2.id, sub5);
        manager.PrintAll();
        //System.out.println("=============");
        //manager.MySubtasks(epic);
    }
}