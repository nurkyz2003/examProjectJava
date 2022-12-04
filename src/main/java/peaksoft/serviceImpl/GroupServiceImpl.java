package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.model.Group;
import peaksoft.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroup(Long id) {
        return groupDao.getAllGroup(id);
    }

    @Override
    public List<Group> getAllGroupsByCourseId(Long courseId) {
        return groupDao.getAllGroupsByCourseId(courseId);
    }

    @Override
    public void addGroup(Long id, Group group) {
        groupDao.addGroup(id, group);
    }

    @Override
    public void addGroupByCourseId(Long id, Long courseId, Group group) {
        groupDao.addGroupByCourseId(id, courseId, group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void updateGroup(Group group, Long id) {
        groupDao.updateGroup(group, id);
    }

    @Override
    public void deleteGroup(Long id) {
        groupDao.deleteGroup(id);
    }

    @Override
    public void assignGroup(Long courseId, Long groupId) {
        groupDao.assignGroup(courseId, groupId);
    }
}
