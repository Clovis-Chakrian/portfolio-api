package com.clovischakrian.portfolio_api.application.services.curriculum;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.DetailCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.ListCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.UpdatedCurriculumDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.exceptions.ElementNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ICurriculumService {
    public List<ListCurriculumDto> list();
    public DetailCurriculumDto detail(UUID curriculumId) throws ElementNotFoundException;
    public DetailCurriculumDto create(NewCurriculumDto newCurriculumDto);
    public DetailCurriculumDto update(UUID curriculumId, UpdatedCurriculumDto updatedCurriculumDto) throws ElementNotFoundException;
    public void delete(UUID curriculumId);
}
