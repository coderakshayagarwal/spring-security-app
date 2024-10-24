package com.security.SpringSecurityExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.security.SpringSecurityExample.model.Student;
import com.security.SpringSecurityExample.repository.StudentRepository;


@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }
}
