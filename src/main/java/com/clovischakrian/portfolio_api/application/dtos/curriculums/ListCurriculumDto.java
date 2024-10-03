package com.clovischakrian.portfolio_api.application.dtos.curriculums;

import java.util.UUID;

public record ListCurriculumDto(UUID curriculumId, String curriculumNick, String name, String email, String position, String presentation) {
}
