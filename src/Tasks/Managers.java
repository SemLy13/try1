package Tasks;

import java.lang.reflect.Type;

public class Managers {
    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
