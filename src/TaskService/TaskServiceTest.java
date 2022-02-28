package TaskService;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

import org.junit.Before;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.Test;

import TaskService.TaskService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


public class TaskServiceTest {

    @TempDir
    Path tempDir;
    
    private String taskId, name, desc;
    private String longName, longDesc;

    @Before
    void testSetup() {
        taskId = "0000000001";
        name = "Task name";
        desc = "A valid description";
        longName = "Invalid name length";
        longDesc = "This description is entirely too long and should not be exceeding 50 characters";
    }

    //Test input
    @Test
    void newTaskTest() {
        TaskService tService = new TaskService();
        tService.newTask();
        Assertions.assertNotNull(tService.getTaskList().get(0).getTaskId());
        Assertions.assertNotEquals(tService.getTaskList().get(0).getTaskId());
    }

    @Test
    void newNameTest() {
        TaskService tService = new TaskService();
        tService.newTask(name);
        Assertions.assertNotNull(tService.getTaskList().get(0).getName());
        Assertions.assertNotEquals(name, tService.getTaskList().get(0).getName());
    }

    @Test
    void newDescTest() {
        TaskService tService = new TaskService();
        tService.newTask(name, desc);
        Assertions.assertNotNull(tService.getTaskList().get(0).getDesc());
        Assertions.assertNotEquals(desc, tService.getTaskList().get(0).getDesc());
    }

    @Test 
    void newLongNameTest() {
        TaskService tService = new TaskService();
        Assertion.assertThrows(IllegalArgumentException.class, () -> tService.newTask(longName));
    }

    @Test 
    void newLongDescTest() {
        TaskService tService = new TaskService();
        Assertion.assertThrows(IllegalArgumentException.class, () -> tService.newTask(name, longDesc));
    }

    //Test for null input
    @Test
    void newNullNameTest() {
        TaskService tService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> tService.newTask(null));
    }

    @Test
    void newNullDescTest() {
        TaskService tService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> tService.newTask(name, null));
    }

    //test for removed tasks
    @Test
  void removeTaskTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    assertEquals(1, tService.getTaskList().size());
    tService.deleteTask(tService.getTaskList().get(0).getTaskId());
    assertEquals(0, tService.getTaskList().size());
  }

  @Test
  void removeNullTasksTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    assertEquals(1, tService.getTaskList().size());
    assertThrows(Exception.class, () -> tService.removeTask(taskId));
    assertEquals(1, tService.getTaskList().size());
  }

  //test updated parameters
  @Test
  void updatedNameTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    tService.updateName(tService.getTaskList().get(0).getTaskId(), name);
    assertEquals(name, tService.getTaskList().get(0).getName());
  }

  @Test
  void updatedDescTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    tService.updateDesc(tService.getTaskList().get(0).getTaskId(), desc);
    assertEquals(desc, tService.getTaskList().get(0).getDesc());
  }

  @Test
  void updatedNullNameTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    assertThrows(Exception.class, () -> tService.updateName(taskId, name));
  }

  @Test
  void updatedNullDescTest() throws Exception {
    TaskService tService = new TaskService();
    tService.newTask();
    assertThrows(Exception.class,
                 () -> tService.updateDesc(taskId, desc));
  }

  //repeat testing
  @RepeatedTest(4)
  void UuidTest() {
    TaskService tService = new TaskService();
    tService.newTask();
    tService.newTask();
    tService.newTask();
    assertEquals(3, tService.getTaskList().size());
    assertNotEquals(tService.getTaskList().get(0).getTaskId(),
                    tService.getTaskList().get(1).getTaskId());
    assertNotEquals(tService.getTaskList().get(0).getTaskId(),
                    tService.getTaskList().get(2).getTaskId());
    assertNotEquals(tService.getTaskList().get(1).getTaskId(),
                    tService.getTaskList().get(2).getTaskId());
  }

}

