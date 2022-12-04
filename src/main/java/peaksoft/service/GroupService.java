package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup(Long id);

    List<Group> getAllGroupsByCourseId(Long courseId);

    void addGroup(Long id, Group group);
    void addGroupByCourseId(Long id, Long courseId, Group group);

    Group getGroupById(Long id);

    void updateGroup(Group group, Long id);

    void deleteGroup(Long id);

    void assignGroup(Long courseId, Long groupId);

}
