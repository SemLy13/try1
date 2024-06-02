package Tasks;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import static Tasks.Task.fromJson;

public class HTTPTaskManager extends FileBackendTasksManager {
    private final KVTaskClient kvTaskClient;
    private final Gson gson;

    public HTTPTaskManager(String serverUrl) throws IOException {
        super(null);
        this.kvTaskClient = new KVTaskClient(serverUrl);
        this.gson = new Gson();
        loadFromServer();
    }

    private void loadFromServer() throws IOException {
        String json = kvTaskClient.load("tasks");
        if (json != null && !json.isEmpty()) {
            // Assuming there's a method to load tasks from JSON
            fromJson(json);
        }
    }

    @Override
    protected void save() {
        try {
            String json = toJson(); // Assuming there's a method to convert tasks to JSON
            kvTaskClient.put("tasks", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toJson() {
        // Преобразуйте ваши задачи в JSON строку
        List<Task> tasks = getAllTasks(); // Предполагается, что у вас есть метод getAllTasks
        return gson.toJson(tasks);
    }
    private List<Task> getAllTasks() {
        // Реализуйте этот метод для возврата всех задач
        // Пример: return new ArrayList<>(tasks.values());
        return null;
    }
}