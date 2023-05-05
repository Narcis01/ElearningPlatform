package com.naical.professor;

import com.naical.course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Component
public class Professor {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "professor")
    private Set<Course> course;
}
