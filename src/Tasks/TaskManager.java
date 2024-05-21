package Tasks;

interface TaskManager {

    void addTask(Task task);
    void addEpic(Epic epic);
    void addSubTask(Subtask subtask);
    void UpdateTask(String id, Task task);
    void UpdateSubtask(String id, Subtask subtask);
    void PrintAll();
    void GetTask(String id);
    void GetEpic(String id);
    void GetSubtask(String id);
    void MySubtasks(Epic epic);
    void RemoveTask(String id);
    void RemoveEpic(String id);
    void RemoveSubtask(String id);
    void RemoveAllTask();
    void RemoveAllEpic();
    void RemoveAllSubtask();
    void RemoveAll();
    Task getTask(String id);
}
