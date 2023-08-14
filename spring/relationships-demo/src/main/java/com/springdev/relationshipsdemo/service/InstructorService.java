package com.springdev.relationshipsdemo.service;

import com.springdev.relationshipsdemo.entity.Course;
import com.springdev.relationshipsdemo.entity.Instructor;
import com.springdev.relationshipsdemo.repository.CourseRepository;
import com.springdev.relationshipsdemo.repository.InstructorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InstructorService {
    private InstructorRepository instructorRepository;
    private CourseRepository courseRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, CourseRepository courseService) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseService;
    }

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public Instructor findById(int id) {
        return instructorRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    public void deleteById(int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(NullPointerException::new);

        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        instructorRepository.delete(instructor);
    }

    public void update(Instructor instructor) {
        instructorRepository.save(instructor);
    }
}
