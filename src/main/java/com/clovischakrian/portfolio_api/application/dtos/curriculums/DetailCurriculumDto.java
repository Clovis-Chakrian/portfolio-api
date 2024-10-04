package com.clovischakrian.portfolio_api.application.dtos.curriculums;

import com.clovischakrian.portfolio_api.application.dtos.education.ListEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.ListExperienceDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.entities.Education;
import com.clovischakrian.portfolio_api.domain.entities.Experience;

import java.util.List;
import java.util.UUID;

public record DetailCurriculumDto(UUID curriculumId, String curriculumNick, String name, String email, String position, String presentation, List<ListExperienceDto> Experiences, List<ListEducationDto> Education) {
    public DetailCurriculumDto(Curriculum curriculum) {
        this(curriculum.getCurriculumId(), curriculum.getCurriculumNick(), curriculum.getName(), curriculum.getEmail(), curriculum.getPosition(), curriculum.getPresentation(), curriculum.getExperiences().stream().map(ListExperienceDto::new).toList(), curriculum.getEducation().stream().map(ListEducationDto::new).toList());
    }
}
