package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TaskDao;
import peaksoft.model.Task;
import peaksoft.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return taskDao.getAllTasks(id);
    }

    @Override
    public void addTask(Long id, Task task) {
        taskDao.addTask(id, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void updateTask(Task task, Long id) {
        taskDao.updateTask(task,id);
    }

    @Override
    public void deleteTask(Long id) {
        taskDao.deleteTask(id);
    }
}
