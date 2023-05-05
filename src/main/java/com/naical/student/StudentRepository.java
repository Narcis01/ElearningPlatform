package com.naical.student;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StudentRepository extends JpaRepositoryImplementation<Student, Integer> {
    Student findByName(String name);
}
