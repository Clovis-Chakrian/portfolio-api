package com.clovischakrian.portfolio_api.application.dtos.experience;

import java.util.Date;
import java.util.UUID;

public record NewExperienceDto(String position, String institution, Date begined, Date finished, String description) {
}