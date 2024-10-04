package com.clovischakrian.portfolio_api.application.dtos.experience;

import com.clovischakrian.portfolio_api.domain.entities.Education;
import com.clovischakrian.portfolio_api.domain.entities.Experience;

import java.util.Date;
import java.util.UUID;

public record ListExperienceDto(UUID experienceId, String position, String institution, Date begined, Date finished, String description) {
    public ListExperienceDto(Experience experience) {
        this(experience.getExperienceId(), experience.getPosition(), experience.getInstitution(), experience.getBegined(), experience.getFinished(), experience.getDescription());
    }
}