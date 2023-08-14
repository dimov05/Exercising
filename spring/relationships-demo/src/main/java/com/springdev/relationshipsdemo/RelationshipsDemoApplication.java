package com.springdev.relationshipsdemo;

import com.springdev.relationshipsdemo.entity.*;
import com.springdev.relationshipsdemo.service.CourseService;
import com.springdev.relationshipsdemo.service.InstructorDetailService;
import com.springdev.relationshipsdemo.service.InstructorService;
import com.springdev.relationshipsdemo.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RelationshipsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationshipsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService, InstructorDetailService instructorDetailService, StudentService studentService, CourseService courseService) {
        return runner -> {
//            createInstructor(instructorService);
//            Optional<Instructor> instructorById= instructorService.findById(1);
//            System.out.println(instructorById);
//            instructorService.deleteById(1);

//            InstructorDetail instructorDetailById = instructorDetailService.findById(2);
//            System.out.println(instructorDetailById);
//            instructorDetailService.deleteById(2);

//            createInstructorWithCourses(instructorService);

//            findInstructorWithCourses(instructorService);

//            findCoursesForInstructor(courseService, instructorService);

//            updateInstructor(instructorService);

//            updateCourse(courseService);

//            deleteInstructor(instructorService);
//            deleteCourseById(courseService);

//            createCourseAndReviews(courseService);

//            retrieveCourseAndReviews(courseService);

//            deleteCourseAndReviews(courseService);

//            createCourseAndStudents(courseService);

//            findCourseAndStudentsByCourseId(courseService);

//            findStudentAndCoursesByStudentId(studentService);

//            addMoreCoursesToStudent(studentService);

//            deleteCourse(courseService);

            deleteStudentById(studentService);
        };


    }

    private void deleteStudentById(StudentService studentService) {
        studentService.deleteById(2);
    }

    private void deleteCourse(CourseService courseService) {
        Course course = courseService.findCourseById(15);
        courseService.delete(course);
    }

    private void addMoreCoursesToStudent(StudentService studentService) {
        Student student = studentService.findStudentById(1);
        Course course1 = new Course("Rubiks Cube course");
        Course course2 = new Course("Master Chef Cube course");
        student.addCourse(course1);
        student.addCourse(course2);
        studentService.update(student);
    }

    private void findStudentAndCoursesByStudentId(StudentService studentService) {
        Student student = studentService.findStudentById(2);
        List<Course> courses = student.getCourses();
        System.out.println(student);
        System.out.println(courses.size());
    }

    private void findCourseAndStudentsByCourseId(CourseService courseService) {
        Course course = courseService.findCourseById(15);
        List<Student> students = course.getStudents();
        System.out.println(course);
        System.out.println(students.size());
    }

    private void createCourseAndStudents(CourseService courseService) {
        Course course = new Course("F1 MASTERS");

        Student student1 = new Student("Dimo", "Dimov", "dimo@abv.bg");
        Student student2 = new Student("Gergana", "Ivanova", "Gergana@abv.bg");
        Student student3 = new Student("Viktoria", "Peneva", "Viktoria@abv.bg");
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        courseService.save(course);
    }

    private void deleteCourseAndReviews(CourseService courseService) {
        Course course = courseService.findCourseById(10);
        courseService.deleteById(course.getId());
    }

    private void retrieveCourseAndReviews(CourseService courseService) {
        Course course = courseService.findCourseById(10);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(CourseService courseService) {
        Course tempCourse = new Course("Pacman Unlimited");
        tempCourse.addReview(new Review("Great course :)"));
        tempCourse.addReview(new Review("Amazing!!"));
        tempCourse.addReview(new Review("Job well done!"));
        tempCourse.addReview(new Review("Awful course :("));
        tempCourse.addReview(new Review("Best course ever!"));

        courseService.save(tempCourse);
    }

    private void deleteCourseById(CourseService courseService) {
        courseService.deleteById(15);
    }

    private void deleteInstructor(InstructorService instructorService) {
        instructorService.deleteById(1);
    }

    private void updateCourse(CourseService courseService) {
        Course course = courseService.findCourseById(10);
        course.setTitle("Replaced Title");
        courseService.update(course);
    }

    public void updateInstructor(InstructorService instructorService) {
        Instructor instructor = instructorService.findById(1);
        instructor.setEmail("replaced@email.com");
        instructorService.save(instructor);
    }

    private void findCoursesForInstructor(CourseService courseService, InstructorService instructorService) {
        Instructor instructor = instructorService.findById(1);

        List<Course> courses = courseService.findCourseByInstructorId(instructor.getId());

        System.out.println(instructor);
        System.out.println(courses);
    }


    private void findInstructorWithCourses(InstructorService instructorService) {
        Instructor instructor = instructorService.findById(1);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(InstructorService instructorService) {
        Instructor instructor = new Instructor(
                "Chad", "Darby", "chad@abv.bg");
        InstructorDetail instructorDetail = new InstructorDetail(
                "http://www.luv2c.com/youtube", "Cycling!");
        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("Air Guitar");
        Course course2 = new Course("Swimming");
        Course course3 = new Course("Badmington");
        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);

        instructorService.save(instructor);

    }

    private void createInstructor(InstructorService instructorService) {
//        Instructor instructor = new Instructor(
//                "Chad", "Darby", "chad@abv.bg"
//        );
//        InstructorDetail instructorDetail = new InstructorDetail(
//                "http://www.luv2c.com/youtube",
//                "Cycling!");
//        instructor.setInstructorDetail(instructorDetail);
//        instructorService.save(instructor);
//        Instructor instructor = new Instructor(
//                "Dimo", "Dimov", "dimo@abv.bg"
//        );
//        InstructorDetail instructorDetail = new InstructorDetail(
//                "http://www.luv2c.com/instagram",
//                "MTB!");
//        instructor.setInstructorDetail(instructorDetail);
//        instructorService.save(instructor);
    }
}
