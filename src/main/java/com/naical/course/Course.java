package com.naical.course;

import com.naical.professor.Professor;
import com.naical.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Component
public class Course {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    @JoinColumns(@JoinColumn(name = "course") )
    private Set<Professor> professor;

    @ManyToMany
    @JoinColumn(name = "course")
    private Set<Student> student;
}
