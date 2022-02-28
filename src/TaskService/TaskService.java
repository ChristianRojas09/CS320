package TaskService;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class TaskService {
    
    //create an instance of Task
    public static List<Task> taskList = new ArrayList<>();

    private String newId() {
        return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    private Task findTask(String taskId) throws Exception {
        int index = 0;
        while(index < taskList.size()) {
            if(taskId.equals(taskList.get(index).getTaskId())) {
                return taskList.get(index);
            }
            index++;
        }
        throw new Exception("Error: This task does not exist");
    }

    // declare newTask method
    public void newTask() {
        Task task = new Task(newId(), null, null);
        taskList.add(task);
    }

    public void newTask(String name) {
        Task task = new Task(newId(), name);
        taskList.add(task);
    }

    public void newTask(String name, String desc) {
        Task task = new Task(newId(), name, desc);
        taskList.add(task);
    }

    public void removeTask(String taskId) throws Exception {
        taskList.remove(findTask(taskId));
    }

    public void updateName(String taskId, String name) throws Exception {
        findTask(taskId).setName(name);
    }

    public void updateDesc(String taskId, String desc) throws Exception {
        findTask(taskId).setDesc(desc);
    }

    //update ArrayList Task
    public List<Task> getTaskList() {
        return taskList;
    }
}
