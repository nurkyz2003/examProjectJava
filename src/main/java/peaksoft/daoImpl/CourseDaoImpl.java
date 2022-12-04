package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.CourseDao;
import peaksoft.model.Company;
import peaksoft.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourses(Long id) {
        return manager.createQuery("select c from Course c where c.company.id = :id", Course.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public void addCourse(Long id, Course course) {
        Company company = manager.find(Company.class,id);
        company.addCourse(course);
        course.setCompany(company);
        manager.merge(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return manager.find(Course.class,id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Course updatedCourse = manager.find(Course.class,id);
        updatedCourse.setCourseName(course.getCourseName());
        updatedCourse.setDuration(course.getDuration());
        updatedCourse.setDescription(course.getDescription());
        manager.merge(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = manager.find(Course.class, id);
        course.setCompany(null);
        manager.remove(course);
    }
}
