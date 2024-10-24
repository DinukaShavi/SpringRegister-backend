package edu.icet.crm.service;

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

    @Override
    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setGuardianName(student.getGuardianName());
        studentEntity.setGuardianContact(student.getGuardianContact());
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
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setGuardianName(student.getGuardianName());
            existingStudent.setGuardianContact(student.getGuardianContact());
            return studentRepository.save(existingStudent);
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