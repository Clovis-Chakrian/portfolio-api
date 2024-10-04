package com.clovischakrian.portfolio_api.application.services.curriculum;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.DetailCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.ListCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.UpdatedCurriculumDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.repositories.ICurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CurriculumService implements ICurriculumService {
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public List<ListCurriculumDto> list() {
        return this.curriculumRepository.findAll().stream().map(ListCurriculumDto::new).toList();
    }

    @Override
    public DetailCurriculumDto detail(UUID curriculumId) {
        Curriculum curriculum = this.curriculumRepository.findById(curriculumId).orElseThrow();
        return new DetailCurriculumDto(curriculum);
    }

    @Override
    public DetailCurriculumDto create(NewCurriculumDto newCurriculumDto) {
        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumNick(newCurriculumDto.curriculumNick());
        curriculum.setName(newCurriculumDto.name());
        curriculum.setEmail(newCurriculumDto.email());
        curriculum.setPosition(newCurriculumDto.position());
        curriculum.setPresentation(newCurriculumDto.presentation());

        this.curriculumRepository.save(curriculum);

        return new DetailCurriculumDto(curriculum);
    }

    @Override
    public DetailCurriculumDto update(UUID curriculumId, UpdatedCurriculumDto updatedCurriculumDto) {
        Curriculum curriculum = this.curriculumRepository.findById(curriculumId).orElseThrow();
        curriculum.setCurriculumNick(updatedCurriculumDto.curriculumNick());
        curriculum.setName(updatedCurriculumDto.name());
        curriculum.setEmail(updatedCurriculumDto.email());
        curriculum.setPosition(updatedCurriculumDto.position());
        curriculum.setPresentation(updatedCurriculumDto.presentation());

        this.curriculumRepository.save(curriculum);

        return new DetailCurriculumDto(curriculum);
    }

    @Override
    public void delete(UUID curriculumId) {
        this.curriculumRepository.deleteById(curriculumId);
    }
}
