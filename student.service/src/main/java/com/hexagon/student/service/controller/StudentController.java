package com.hexagon.student.service.controller;

import com.hexagon.student.service.dto.StudentResponseDTO;
import com.hexagon.student.service.entity.Student;
import com.hexagon.student.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> fetchStudents() {
        return studentService.fetchStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO fetchStudentById(@PathVariable String id) {
        return studentService.fetchStudentById(id);
    }
}
