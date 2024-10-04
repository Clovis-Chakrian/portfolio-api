package com.clovischakrian.portfolio_api.application.dtos.curriculums;

import jakarta.validation.constraints.NotBlank;

public record NewCurriculumDto(@NotBlank(message = "Apelido para o currículo é obrigatório") String curriculumNick, @NotBlank(message = "Nome para o currículo é obrigatório") String name, @NotBlank(message = "Email para o currículo é obrigatório") String email, @NotBlank(message = "Cargo para o currículo é obrigatório") String position, @NotBlank(message = "Apresentação para o currículo é obrigatório") String presentation) {
}