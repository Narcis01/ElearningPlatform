package com.naical.professor;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ProfessorRepository extends JpaRepositoryImplementation<Professor, Integer> {
}
