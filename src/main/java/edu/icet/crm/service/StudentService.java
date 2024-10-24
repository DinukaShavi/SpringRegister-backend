package edu.icet.crm.service;


import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.model.Student;

import java.util.List;

public interface StudentService {
    StudentEntity saveStudent(Student student);
    List<StudentEntity> getAllStudents();
    StudentEntity updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
