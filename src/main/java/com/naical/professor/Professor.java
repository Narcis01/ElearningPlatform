package com.naical.professor;

import com.naical.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Component
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Professor")
public class Professor {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Professor_Course",
            joinColumns = { @JoinColumn(name = "professor_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Course> course;
}
