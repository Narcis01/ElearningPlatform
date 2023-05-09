package com.naical.controller;

import com.naical.course.Course;
import com.naical.course.CourseServiceImp;
import com.naical.student.Student;
import com.naical.student.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Component
public class StudentController {

    private final StudentServiceImp studentServiceImp;
    private final CourseServiceImp courseServiceImp;
    @PostMapping(value = "/add/{name}&{courseId}")
    @ResponseBody
    public Student add(@PathVariable String name, @PathVariable int courseId) {
        Student student = Student.builder().name(name).build();
        Course course = courseServiceImp.findById(courseId);
        student.addCourse(course);
        log.info("..in add...");
        return studentServiceImp.save(student);
    }

    @PostMapping(value = "/add/{name}")
    @ResponseBody
    public Student add(@PathVariable String name) {
        Student student = Student.builder().name(name).build();
        log.info("..in add...");
        return studentServiceImp.save(student);
    }
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam int id) {
        studentServiceImp.delete(id);
        log.info("...in delete...");
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Student update(@RequestParam String name, @RequestParam String newName){
        Student student = studentServiceImp.getByName(name);
        student.setName(newName);
        return studentServiceImp.save(student);
    }

    @GetMapping(value = "/students")
    @ResponseBody
    public List<Student> students(){
        return studentServiceImp.findAll();
    }


}
