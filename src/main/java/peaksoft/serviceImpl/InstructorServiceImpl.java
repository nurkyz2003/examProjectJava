package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.InstructorDao;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;


import java.io.IOException;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }


    @Override
    public List<Instructor> getAllList() {
        return instructorDao.getAllList();
    }

    @Override
    public List<Instructor> getAllInstructor(Long courseId) {
        return instructorDao.getAllInstructor(courseId);
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) throws IOException {
        instructorDao.addInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public void updateInstructor(Instructor instructor, Long id) throws IOException {
        instructorDao.updateInstructor(instructor, id);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorDao.deleteInstructor(id);
    }

    @Override
    public void assignInstructor(Long courseId, Long instructorId) throws IOException {
        instructorDao.assignInstructor(courseId, instructorId);
    }
}
