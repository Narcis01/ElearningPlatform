package com.naical.controller;

import com.naical.professor.Professor;
import com.naical.professor.ProfessorServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorServiceImp professorServiceImp;

    @PostMapping("/add")
    public Professor add(@RequestParam String name) {
        Professor professor = Professor.builder().name(name).build();
        return professorServiceImp.save(professor);
    }
}
