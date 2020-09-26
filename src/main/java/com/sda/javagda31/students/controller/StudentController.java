package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.model.Student;
import com.sda.javagda31.students.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("newStudent", new Student());
        return "student_form";
    }

    @PostMapping("/add")
    public String submitForm(Student student) {
        log.info("Received" + student);
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Student> list = studentService.findAllStudents();
        model.addAttribute("students", list);
        return "student_list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "studentId") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(name = "id") Long studentId, Model model) {
        Optional<Student> studentOptional= studentService.findStudent(studentId);
        return "student_details";
    }
}
