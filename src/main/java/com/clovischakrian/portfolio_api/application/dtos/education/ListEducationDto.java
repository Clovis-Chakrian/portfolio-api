package com.clovischakrian.portfolio_api.application.dtos.education;

import com.clovischakrian.portfolio_api.domain.entities.Education;

import java.util.Date;
import java.util.UUID;

public record ListEducationDto(UUID educationId, Date begined, Date finished, String institution, String courseName) {
    public ListEducationDto(Education education) {
        this(education.getEducationId(), education.getBegined(), education.getFinished(), education.getInstitution(), education.getCourseName());
    }
}