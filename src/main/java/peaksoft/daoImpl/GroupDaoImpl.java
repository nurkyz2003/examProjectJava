package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.GroupDao;
import peaksoft.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Group> getAllGroup(Long id) {
        return manager.createQuery("select g from Group g where g.company.id = :id", Group.class).setParameter("id", id).getResultList();

    }

    @Override
    public List<Group> getAllGroupsByCourseId(Long courseId) {
        List<Group> groupList = manager.find(Course.class,courseId).getGroups();
        groupList.forEach(System.out::println);
        return groupList;
    }

    @Override
    public void addGroup(Long id, Group group) {
        Company company = manager.find(Company.class,id);
        company.addGroup(group);
        group.setCompany(company);
        manager.merge(group);
    }

    @Override
    public void addGroupByCourseId(Long id, Long courseId, Group group) {
        Company company = manager.find(Company.class, id);
        Course course = manager.find(Course.class, courseId);
        company.addGroup(group);
        group.setCompany(company);
        group.addCourse(course);
        course.addGroup(group);
        manager.merge(course);
        manager.merge(company);
    }

    @Override
    public Group getGroupById(Long id) {
        return manager.find(Group.class, id);
    }

    @Override
    public void updateGroup(Group group, Long id) {
        Group group1 = getGroupById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setImage(group.getImage());
        manager.merge(group1);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = manager.find(Group.class, id);
        for (Student s: group.getStudents()) {
            group.getCompany().minusStudent();
        }
        for (Course c: group.getCourses()) {
            for (Student student: group.getStudents()) {
                for (Instructor i: c.getInstructors()) {
                    i.minus();
                }
            }
        }
        for (Course c : group.getCourses()) {
            c.getGroups().remove(group);
            group.minusCount();
        }
        group.getStudents().forEach(x -> manager.remove(x));
        group.setCourses(null);
        manager.remove(group);
    }

    @Override
    public void assignGroup(Long courseId, Long groupId) {
        Group group = manager.find(Group.class, groupId);
        Course course = manager.find(Course.class, courseId);
        group.addCourse(course);
        course.addGroup(group);
        manager.merge(group);
        manager.merge(course);
    }
}
