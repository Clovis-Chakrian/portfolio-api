package com.clovischakrian.portfolio_api.application.dtos.curriculums;

import com.clovischakrian.portfolio_api.domain.entities.Education;
import com.clovischakrian.portfolio_api.domain.entities.Experience;

import java.util.List;
import java.util.UUID;

public record DetailCurriculumDto(UUID curriculumId, String curriculumNick, String name, String email, String position, String presentation, List<Experience> Experiences, List<com.clovischakrian.portfolio_api.domain.entities.Education> Education) {
}
