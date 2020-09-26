package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.model.Student;
import com.sda.javagda31.students.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/add")
    public String getForm(Model model ){
        model.addAttribute("newStudent", new Student());
        return "student_form";
    }
    @PostMapping("/add")
    public String submitForm(Student student){

    }
}
