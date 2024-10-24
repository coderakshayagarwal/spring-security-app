package com.security.SpringSecurityExample.repository;

import org.springframework.stereotype.Repository;

import com.security.SpringSecurityExample.model.Student;

import java.util.List;
import java.util.ArrayList;

@Repository
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>(List.of(
        new Student(1, "Aruna", 90),
        new Student(2, "Varuna", 20)
    ));

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }
}
