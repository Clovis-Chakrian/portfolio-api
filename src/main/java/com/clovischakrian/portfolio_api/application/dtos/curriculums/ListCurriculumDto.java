package com.clovischakrian.portfolio_api.application.dtos.curriculums;

import com.clovischakrian.portfolio_api.domain.entities.Curriculum;

import java.util.UUID;

public record ListCurriculumDto(UUID curriculumId, String curriculumNick, String name, String email, String position, String presentation) {
    public ListCurriculumDto(Curriculum curriculum) {
        this(curriculum.getCurriculumId(), curriculum.getCurriculumNick(), curriculum.getName(), curriculum.getEmail(), curriculum.getPosition(), curriculum.getPresentation());
    }
}
