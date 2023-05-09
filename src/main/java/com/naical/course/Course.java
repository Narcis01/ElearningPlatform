package com.naical.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naical.professor.Professor;
import com.naical.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Component
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "course")
    private Set<Professor> professor;

    @JsonIgnore
    @ManyToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private Set<Student> student = new HashSet<>();

    public void addStudent(Student student) {
        if(this.student == null){
            this.student = new HashSet<>();
        }
        this.getStudent().add(student);
    }

}
