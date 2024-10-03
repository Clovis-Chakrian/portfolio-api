package com.clovischakrian.portfolio_api.application.services.curriculum;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;

public interface ICurriculumService {
    public Curriculum create(NewCurriculumDto newCurriculumDto);
}
