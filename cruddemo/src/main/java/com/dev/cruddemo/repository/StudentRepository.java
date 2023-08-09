package com.dev.cruddemo.repository;

import com.dev.cruddemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    Student findById(Long id);

    List<Student> findAll();

    List<Student> findAllOrderByLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Long id);

    long deleteAll();
}
