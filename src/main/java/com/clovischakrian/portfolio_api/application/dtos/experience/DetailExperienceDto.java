package com.clovischakrian.portfolio_api.application.dtos.experience;

import java.util.Date;
import java.util.UUID;

public record DetailExperienceDto(UUID experienceId, String position, String institution, Date begined, Date finished, String description) {
}