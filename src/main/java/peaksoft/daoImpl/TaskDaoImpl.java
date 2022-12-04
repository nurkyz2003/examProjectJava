package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.TaskDao;
import peaksoft.model.Lesson;
import peaksoft.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Task> getAllTasks(Long id) {
        return manager.createQuery("select t from Task t where t.lesson.id = :id", Task.class).setParameter("id", id).getResultList();
    }

    @Override
    public void addTask(Long id, Task task) {
        Lesson lesson = manager.find(Lesson.class, id);
        lesson.addTask(task);
        task.setLesson(lesson);
        manager.merge(lesson);
    }

    @Override
    public Task getTaskById(Long id) {
        return manager.find(Task.class, id);
    }

    @Override
    public void updateTask(Task task, Long id) {
        Task task1 = manager.find(Task.class, id);
        task1.setTaskName(task.getTaskName());
        task1.setTaskText(task.getTaskText());
        task1.setDeadLine(task.getDeadLine());
        manager.merge(task1);
    }

    @Override
    public void deleteTask(Long id) {
        manager.remove(manager.find(Task.class, id));
    }
}
