package com.example.student.repository;

import com.example.student.entity.student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<student, Long> {
}
