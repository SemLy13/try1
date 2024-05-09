package Tasks;

public class Subtask extends Task {
    public String EpicId;
    public Subtask(String EpicId, String name, String description, Status status) {
        super(name, description, status);
        this.EpicId = EpicId;
    }
    public Subtask(String EpicId, String id, String name, String description, Status status) {
        super(id, name, description, status);
        this.EpicId = EpicId;
    }

    public Subtask(String EpicId, String name, String description) {
        super(name, description);
        this.EpicId = EpicId;
        status = Status.NEW;
    }

}
