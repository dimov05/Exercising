package com.springdev.relationshipsdemo.service;

import com.springdev.relationshipsdemo.entity.Course;
import com.springdev.relationshipsdemo.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findCourseByInstructorId(int instructorId) {
        return courseRepository.findCoursesByInstructorId(instructorId);
    }

    public void update(Course course) {
        courseRepository.save(course);
    }

    public Course findCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
    public void delete(Course course){
        courseRepository.delete(course);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course findById(int id) {
        return courseRepository.findCourseById(id);
    }
}
