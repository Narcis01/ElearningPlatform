package com.naical.course;

import org.springframework.stereotype.Component;

@Component
public interface CourseService {
    Course save(Course course);
    Course findById(int id);
    Course findByName(String name);
}
