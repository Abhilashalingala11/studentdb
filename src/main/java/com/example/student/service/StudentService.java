package com.example.student.service;

import com.example.student.entity.student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public student addStudent(student s) {
        return repo.save(s);
    }

    public List<student> getStudents() {
        return repo.findAll();
    }
    // ✏️ UPDATE STUDENT
    public student updateStudent(Long id, student updated) {

        student s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        s.setName(updated.getName());
        s.setCourse(updated.getCourse());

        return repo.save(s);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}

