package peaksoft.dao;

import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents(Long id);

    void addStudent(Long id, Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student, Long id);

    void deleteStudent(Long id);

    void assignStudent(Long groupId, Long studentId);
}
