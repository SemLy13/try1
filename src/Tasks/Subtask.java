package Tasks;

public class Subtask extends Task {
    public String EpicId, id;
    Status status;
    public Subtask(String EpicId, String name, String description, Status status) {
        super(name, description, status);
        this.EpicId = EpicId;
        this.status = status;
        id = ID();
    }

    public Subtask(String EpicId, String name, String description) {
        super(name, description);
        this.EpicId = EpicId;
        id = ID();
        status = Status.NEW;
    }

}
