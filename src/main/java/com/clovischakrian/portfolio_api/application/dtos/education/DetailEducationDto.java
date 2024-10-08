package com.clovischakrian.portfolio_api.application.dtos.education;

import java.util.Date;
import java.util.UUID;

public record DetailEducationDto(UUID educationId, Date begined, Date finished, String institution, String courseName) {
}