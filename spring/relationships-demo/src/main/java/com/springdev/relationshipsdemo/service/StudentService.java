package com.springdev.relationshipsdemo.service;

import com.springdev.relationshipsdemo.entity.Student;
import com.springdev.relationshipsdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
