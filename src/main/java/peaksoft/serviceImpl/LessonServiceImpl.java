package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.LessonDao;
import peaksoft.model.Lesson;
import peaksoft.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;

    @Autowired
    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return lessonDao.getAllLessons(id);
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
        lessonDao.addLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public void updateLesson(Lesson lesson, Long id) {
        lessonDao.updateLesson(lesson, id);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonDao.deleteLesson(id);
    }
}
