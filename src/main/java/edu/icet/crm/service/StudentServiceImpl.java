package edu.icet.crm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.model.Student;
import edu.icet.crm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = objectMapper.convertValue(student, StudentEntity.class);
        return studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity updateStudent(Long id, Student student) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntity existingStudent = optionalStudent.get();
            StudentEntity updatedStudent = objectMapper.convertValue(student, StudentEntity.class);
            updatedStudent.setId(existingStudent.getId());
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
}