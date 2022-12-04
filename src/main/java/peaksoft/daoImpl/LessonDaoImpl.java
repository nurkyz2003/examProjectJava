package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.LessonDao;
import peaksoft.model.Course;
import peaksoft.model.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonDaoImpl implements LessonDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return manager.createQuery("select s from Lesson s where s.course.id = :id", Lesson.class).setParameter("id", id).getResultList();
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
        Course course = manager.find(Course.class, id);
        course.addLesson(lesson);
        lesson.setCourse(course);
        manager.merge(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class, id);
    }

    @Override
    public void updateLesson(Lesson lesson, Long id) {
        Lesson lesson1 = manager.find(Lesson.class, id);
        lesson1.setLessonName(lesson.getLessonName());
        manager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        manager.remove(manager.find(Lesson.class, id));
    }
}
