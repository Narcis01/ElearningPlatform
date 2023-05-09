package com.naical.controller;


import com.naical.course.Course;
import com.naical.course.CourseServiceImp;
import com.naical.student.Student;
import com.naical.student.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImp courseServiceImp;
    private final StudentServiceImp studentServiceImp;
    @PostMapping("/add")
    public Course add(@RequestParam String name,@RequestParam int studentId){
        Course course = Course.builder().name(name).build();
        Student student = studentServiceImp.findById(studentId);
        course.addStudent(student);
        return courseServiceImp.save(course);
    }

}
