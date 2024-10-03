package com.clovischakrian.portfolio_api.application.services.curriculum;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.ListCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.UpdatedCurriculumDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;

import java.util.List;
import java.util.UUID;

public interface ICurriculumService {
    public List<ListCurriculumDto> list();
    public Curriculum detail(UUID curriculumId);
    public Curriculum create(NewCurriculumDto newCurriculumDto);
    public Curriculum update(UUID curriculumId, UpdatedCurriculumDto updatedCurriculumDto);
    public void delete(UUID curriculumId);
}
