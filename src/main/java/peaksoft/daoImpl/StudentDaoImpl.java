package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.model.Group;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Student> getAllStudents(Long id) {
        return manager.createQuery("select s from Student s where s.groups.id = :id", Student.class)
                .setParameter("id", id).getResultList();

    }

    @Override
    public void addStudent(Long id, Student student) {
        Group group = manager.find(Group.class, id);
        group.addStudent(student);
        student.setGroups(group);
        manager.merge(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return manager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        Student student1 = manager.find(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setPhoneNumber(student.getPhoneNumber());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        manager.merge(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        manager.remove(manager.find(Student.class, id));
    }

    @Override
    public void assignStudent(Long groupId, Long studentId) {
        Student student = manager.find(Student.class, studentId);
        Group group = manager.find(Group.class, groupId);
        group.addStudent(student);
        student.setGroups(group);
        manager.merge(student);
    }
}
