package TaskService;

public class Task {

    private String taskId;
    private String name;
    private String desc;

    //Public constructor to accept the three strings
    public Task(String taskId, String name, String desc) {

        this.taskId = taskId;
        this.name = name;
        this.desc = desc;
    }

    //getter for ID input
    public String getTaskId() {
        return taskId;
    }

    //getter for name input
    public String getName() {
        return name;
    }

    //getter for description input
    public String getDesc() {
        return desc;
    }

    //setter for description
    public void setDesc(String desc) {
        if(desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid: Description cannot be longer than 50 characters.");
        }
        else {
            this.desc = desc;
        }
    }

    //setter for name
    public void setName(String name) {
        if(name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid: name cannot be longer than 20 characters.");
        }
        else {
            this.name = name;
        }
    }

    //setter for ID
    public void settaskId(String taskId) {
        if(taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid: ID cannot be longer than 10 characters.");
        }
        else {
            this.taskId = taskId;
        }
    }

}
