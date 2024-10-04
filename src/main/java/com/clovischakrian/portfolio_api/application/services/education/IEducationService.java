package com.clovischakrian.portfolio_api.application.services.education;

import com.clovischakrian.portfolio_api.application.dtos.education.DetailEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.ListEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.NewEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.UpdatedEducationDto;

import java.util.List;
import java.util.UUID;

public interface IEducationService {
    public List<ListEducationDto> list(UUID curriculumId);
    public DetailEducationDto detail(UUID educationId);
    public DetailEducationDto create(UUID curriculumId, NewEducationDto newEducationDto);
    public DetailEducationDto update(UUID educationId, UpdatedEducationDto updatedEducationDto);
    public void delete(UUID educationId);
}
