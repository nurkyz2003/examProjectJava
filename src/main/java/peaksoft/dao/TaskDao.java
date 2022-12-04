package peaksoft.dao;

import peaksoft.model.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getAllTasks(Long id);

    void addTask(Long id, Task task);

    Task getTaskById(Long id);

    void updateTask(Task task, Long id);

    void deleteTask(Long id);
}
