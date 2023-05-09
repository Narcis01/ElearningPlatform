package com.naical.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfessorServiceImp implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}
