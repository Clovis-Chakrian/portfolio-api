package com.clovischakrian.portfolio_api.application.services.experience;

import com.clovischakrian.portfolio_api.application.dtos.experience.DetailExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.ListExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.NewExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.UpdatedExperienceDto;

import java.util.List;
import java.util.UUID;

public interface IExperienceService {
    public List<ListExperienceDto> list(UUID curriculumId);
    public DetailExperienceDto detail(UUID educationId);
    public DetailExperienceDto create(UUID curriculumId, NewExperienceDto newExperienceDto);
    public DetailExperienceDto update(UUID educationId, UpdatedExperienceDto updatedExperienceDto);
    public void delete(UUID educationId);
}
