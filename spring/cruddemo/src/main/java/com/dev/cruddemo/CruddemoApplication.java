package com.dev.cruddemo;

import com.dev.cruddemo.entity.Student;
import com.dev.cruddemo.repository.StudentRepository;
import com.dev.cruddemo.repository.StudentRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    public CruddemoApplication(StudentRepository studentRepo) {
        studentRepository = studentRepo;
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepositoryImpl studentRepository) {
        return runner -> {
            //createStudent(studentRepository);
            createMultipleStudents(studentRepository);
            //readStudent(studentRepository);
            //queryForStudents(studentRepository);
            //queryForStudentsByLastName(studentRepository);
            //updateStudent(studentRepository);
            //deleteStudent(studentRepository);
            //deleteAllStudents(studentRepository);
        };
    }

    private void deleteAllStudents(StudentRepositoryImpl studentRepository) {
        System.out.println(studentRepository.deleteAll());
    }

    private void deleteStudent(StudentRepositoryImpl studentRepository) {
        long studentId = 3;
        studentRepository.delete(studentId);
    }

    private void updateStudent(StudentRepositoryImpl studentRepository) {
        long studentId = 1;
        Student myStudent = studentRepository.findById(studentId);
        myStudent.setFirstName("John");
        studentRepository.update(myStudent);
        System.out.println("Updated student: " + studentRepository.findById(studentId));
    }

    private void queryForStudentsByLastName(StudentRepositoryImpl studentRepository) {
        List<Student> theStudents = studentRepository.findByLastName("Duck");
        for (Student student : theStudents) {
            System.out.println(student);
        }

    }

    private void queryForStudents(StudentRepositoryImpl studentRepository) {
        List<Student> theStudents = studentRepository.findAll();
        for (Student student : theStudents) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentRepositoryImpl studentRepository) {
        System.out.println("Creating a new student..");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@abv.bg");
        System.out.println("SAving it");
        studentRepository.save(tempStudent);

        int idOfStudent = tempStudent.getId();
        System.out.println("Saved id of student: " + idOfStudent);
        Student student = studentRepository.findById((long) idOfStudent);
        System.out.println("Found the student: " + student);
    }

    private void createMultipleStudents(StudentRepositoryImpl studentRepository) {
        Student tempStudent1 = new Student("Dimo", "Dimov", "dimo@abv.bg");
        Student tempStudent2 = new Student("Petur", "Pavlov", "pesho@abv.bg");
        Student tempStudent3 = new Student("Ivan", "Kolev", "ivan@abv.bg");
        studentRepository.save(tempStudent1);
        studentRepository.save(tempStudent2);
        studentRepository.save(tempStudent3);
    }

    private void createStudent(StudentRepository studentRepository) {
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@abv.bg");

        System.out.println("Saving the student...");
        studentRepository.save(tempStudent);

        System.out.println("Saved student. Generated ID : " + tempStudent.getId());
    }

}
