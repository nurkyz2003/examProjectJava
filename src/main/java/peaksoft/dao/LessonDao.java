package peaksoft.dao;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getAllLessons(Long id);

    void addLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    void updateLesson(Lesson lesson, Long id);

    void deleteLesson(Long id);
}
