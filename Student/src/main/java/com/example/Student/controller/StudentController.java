package com.example.Student.controller;


import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student)
    {
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents()
    {
        List<Student> list = studentService.findAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(@PathVariable(name = "school-id") Long id)
    {
        return ResponseEntity.ok(studentService.findAllStudentsBySchoolId(id));
    }

}
