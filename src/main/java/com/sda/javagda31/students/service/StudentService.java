package com.sda.javagda31.students.service;

import com.sda.javagda31.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Dependency Injection mechanizm
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired //inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
