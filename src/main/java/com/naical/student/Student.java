package com.naical.student;


import com.naical.course.Course;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany
    @JoinColumn(name = "student")
    private Set<Course> course;

}
