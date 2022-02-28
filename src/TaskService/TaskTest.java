package TaskService;

import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;
import org.junit.api.Assertions;

import TaskService.Task;


public class TaskTest {

    @TempDir
    Path tempDir;

    private String taskId, name, desc;
    private String longId, longName, longDesc;

    //set the test parameters
    @Before
    void testSetup() {
        taskId = "0000000001";
        name = "Task name";
        desc = "A valid description";
        longId = "0000000001111";
        longName = "Invalid name length";
        longDesc = "This description is entirely too long and should not be exceeding 50 characters";
    }

    //Test all parameters
    @Test
    void getIdTest() {
        Task task = new Task(taskId, null, null);
        Assertions.assertEquals(taskId, task.getTaskId());
    }

    @Test
    void getNameTest() {
        Task task = new Task(taskId, name);
        Assertions.assertEquals(name, task.getName());
    }

    @Test
    void getDescTest() {
        Task task = new Task(taskId, name, desc);
        Assertions.assertEquals(desc, task.getDesc());
    }

    @Test
    void setNameTest() {
        Task task = new Task();
        task.setName(name);
        Assertions.assertEquals(name, task.getName());
    }

    @Test
    void setDescTest() {
        Task task = new Task();
        task.setDesc(desc);
        Assertions.assertEquals(desc, task.getDesc());
    }

    @Test
    void longIdTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(longId));
    }

    @Test
    void longNameTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(longName));
    }

    @Test
    void longDescTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(longDesc));
    }

    //Test to ensure there are no null fields
    @Test
    void NullIdTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
    }

    @Test
    void NullNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void NullDescTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(null));
    }


}
