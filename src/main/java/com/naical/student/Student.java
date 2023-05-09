package com.naical.student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naical.course.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Student_Course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Course> course = new HashSet<>();

    public void addCourse(Course course){
        if(this.course == null){
            this.course = new HashSet<>();
        }
        this.getCourse().add(course);
    }

}
