import Tasks.*;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        // Запуск KVServer
        KVServer kvServer = new KVServer();
        kvServer.start();

        // Создание клиента для взаимодействия с KVServer
        KVTaskClient client = new KVTaskClient("http://localhost:8078");

        // Пример задачи
        Task task = new Task("Task 1", "No");

        // Преобразование задачи в JSON
        String json = Task.toJson(task);
        System.out.println("Task to JSON:");
        System.out.println(json);

        // Сохранение задачи на KVServer
        client.put("task_1", json);

        // Загрузка задачи с KVServer
        String loadedJson = client.load("task_1");
        Task loadedTask = Task.fromJson(loadedJson);

        System.out.println("Loaded Task from KVServer:");
        System.out.println(loadedJson);

        // Запуск HttpTaskServer
        HttpTaskServer httpTaskServer = new HttpTaskServer();
        httpTaskServer.start();


//        InMemoryHistoryManager imhm = (InMemoryHistoryManager) Managers.getDefaultHistory();
//        InMemoryTaskManager manager = new InMemoryTaskManager(imhm);
//
//        //LocalDateTime startTime = LocalDateTime.now();
//        LocalDateTime startTime = LocalDateTime.of(2024, 1, 1, 12, 0);
//        Task task = new Task("Task 1", "No",120, startTime);
//        manager.addTask(task);
//        System.out.println(manager.DefaultTasks.get(task.id).getEndTime());
//        Task task2 = new Task("Task 2", "Yes",90, LocalDateTime.of(2024, 1, 1, 14, 0));
//        manager.addTask(task2);
//        System.out.println(manager.DefaultTasks.get(task2.id).getEndTime());
//        Epic epic = new Epic("epic 1", "Task description",0, LocalDateTime.of(2024, 1, 1, 10, 0));
//        manager.addEpic(epic);
//        Subtask sub = new Subtask(epic.id, "Sub 1", "descr",10, LocalDateTime.of(2024, 1, 1, 11, 30));
//        manager.addSubTask(sub);
//        Subtask sub2 = new Subtask(epic.id, "Sub 2", "!!!!!!!",2, startTime);
//        manager.addSubTask(sub2);
//        Subtask sub3 = new Subtask(epic.id, "Sub 3", "descr",3, startTime);
//        manager.addSubTask(sub3);
//        Epic epic2 = new Epic("epic 2", "Task description", 0 , LocalDateTime.of(2024, 1, 1, 11, 0));
//        manager.addEpic(epic2);
//        System.out.println(manager.EpicTasks.get(epic.id).getEndTime());
//        System.out.println(manager.EpicTasks.get(epic2.id).getEndTime());
//        manager.PrintAll();
//        System.out.println("=============");
//        manager.printPrioritizedTasks();
////        manager.GetSubtask(sub3.id);
////        manager.GetSubtask(sub2.id);
////        manager.GetSubtask(sub.id);
////        manager.GetEpic(epic.id);
////        manager.GetTask(task.id);
////        manager.GetEpic(epic2.id);
////        manager.GetTask(task2.id);
////        //InMemoryTaskManager.GetTask(task3.id);
////        manager.GetEpic(epic.id);
////        manager.GetTask(task.id);
////        manager.GetTask(task2.id);
////        manager.GetSubtask(sub3.id);
////        manager.GetSubtask(sub2.id);
////        manager.GetSubtask(sub.id);
////        manager.GetEpic(epic.id);
////        System.out.println("=============////");
////        imhm.getHistory();
////        imhm.remove(epic.id);
////        System.out.println("=============////");
////        imhm.getHistory();
    }
}