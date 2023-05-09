package com.naical.controller;


import com.naical.course.Course;
import com.naical.course.CourseServiceImp;
import com.naical.student.Student;
import com.naical.student.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImp courseServiceImp;
    private final StudentServiceImp studentServiceImp;

    @PostMapping("/add/{name}/{studentId}")
    public Course add(@PathVariable String name, @PathVariable int studentId) {
        if (courseServiceImp.findByName(name) != null) {
            Course course = courseServiceImp.findByName(name);
            Student student = studentServiceImp.findById(studentId);
            course.addStudent(student);
            student.addCourse(course);
            return courseServiceImp.save(course);

        } else {
            Course course = Course.builder().name(name).build();
            Student student = studentServiceImp.findById(studentId);
            course.addStudent(student);
            student.addCourse(course);
            return courseServiceImp.save(course);
        }
    }

    @PostMapping("/add/{name}")
    public Course add(@PathVariable String name) {
        Course course = Course.builder().name(name).build();
        return courseServiceImp.save(course);
    }

}
