package com.naical.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }
}
