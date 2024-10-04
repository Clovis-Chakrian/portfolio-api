package com.clovischakrian.portfolio_api.application.dtos.education;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record UpdatedEducationDto(@NotBlank(message = "Data de início é uma informação obrigatória") Date begined, @NotBlank(message = "Data de finalização ou previsão de finalização é uma informação obrigatória") Date finished, @NotBlank(message = "A instituição da formação é obrigatória.") String institution, @NotBlank(message = "Nome do curso é obrigatório") String courseName) {
}
