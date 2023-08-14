package com.springdev.relationshipsdemo.repository;

import com.springdev.relationshipsdemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findCoursesByInstructorId(int id);
    Course findCourseById(int id);
}
