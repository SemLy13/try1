package Tasks;

public class Subtask extends Task {
    public String EpicId;
    Status status;
    public Subtask(String EpicId, String name, String description, Status status) {
        super(name, description, status);
        this.EpicId = EpicId;
        this.status = status;
    }

    public Subtask(String EpicId, String name, String description) {
        super(name, description);
        this.EpicId = EpicId;
    }

}
