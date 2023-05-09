package com.naical.student;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    Student save(Student student);
    void delete(int id);
    List<Student> findAll();
    Student getByName(String name);
    Student findById(int id);
}
