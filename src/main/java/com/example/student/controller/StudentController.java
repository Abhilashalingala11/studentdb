package com.example.student.controller;

import com.example.student.entity.student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public student addStudent(@RequestBody student student) {
        return service.addStudent(student);
    }

@GetMapping("/students1")
public String welcome(){
       return "Welcome";
}

    @GetMapping("/students")
    public List<student> getStudents() {
        return service.getStudents();
    }


    @PutMapping("/students/{id}")
    public student updateStudent(@PathVariable Long id,
                                 @RequestBody student student) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted student with id: " + id;
    }
}