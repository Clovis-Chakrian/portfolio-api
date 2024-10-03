package com.clovischakrian.portfolio_api.application.services.curriculum;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.repositories.ICurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService implements ICurriculumService {
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public Curriculum create(NewCurriculumDto newCurriculumDto) {
        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumNick(newCurriculumDto.curriculumNick());
        curriculum.setName(newCurriculumDto.name());
        curriculum.setEmail(newCurriculumDto.email());
        curriculum.setPosition(newCurriculumDto.position());
        curriculum.setPresentation(newCurriculumDto.presentation());

        this.curriculumRepository.save(curriculum);
        
        return curriculum;
    }
}
