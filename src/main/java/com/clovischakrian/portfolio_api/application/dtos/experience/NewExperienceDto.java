package com.clovischakrian.portfolio_api.application.dtos.experience;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record NewExperienceDto(@NotBlank(message = "O cargo é uma informação obrigatória") String position, @NotBlank(message = "A empresa é uma informação obrigatória") String institution, @NotBlank(message = "A data de início é uma informação obrigatória") Date begined, Date finished, @NotBlank(message = "A descrição é uma informação obrigatória") String description) {
}