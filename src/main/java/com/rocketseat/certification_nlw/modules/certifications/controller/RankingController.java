package com.rocketseat.certification_nlw.modules.certifications.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.certifications.controller.useCases.Top10RankingUseCase;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class RankingController {
   
    @Autowired
    private Top10RankingUseCase top10RankingUseCase;

    @GetMapping("/")
    public List<CertificationStudentEntity> top10() {
        return this.top10RankingUseCase.execute();
    }   
}
