package com.naical.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StudentServiceImp implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
         studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElseThrow();
    }
}
