package com.naical.professor;

import org.springframework.stereotype.Component;

@Component

public interface ProfessorService {
    Professor save(Professor professor);
}
