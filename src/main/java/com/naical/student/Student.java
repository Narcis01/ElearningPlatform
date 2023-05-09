package com.naical.student;


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
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student")
    private Set<Course> course = new HashSet<>();

    public void addCourse(Course course){
        if(this.course == null){
            this.course = new HashSet<>();
        }
        this.course.add(course);
    }

}
