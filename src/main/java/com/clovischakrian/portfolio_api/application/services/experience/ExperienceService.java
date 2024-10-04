package com.clovischakrian.portfolio_api.application.services.experience;

import com.clovischakrian.portfolio_api.application.dtos.experience.DetailExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.ListExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.NewExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.UpdatedExperienceDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.entities.Experience;
import com.clovischakrian.portfolio_api.domain.repositories.ICurriculumRepository;
import com.clovischakrian.portfolio_api.domain.repositories.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExperienceService implements IExperienceService {
    @Autowired
    private IExperienceRepository experienceRepository;
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public List<ListExperienceDto> list(UUID curriculumId) {
        return this.experienceRepository.findAllByCurriculumId(curriculumId).stream().map(experience -> new ListExperienceDto(experience)).toList();
    }

    @Override
    public DetailExperienceDto detail(UUID experienceId) {
        Experience experience = this.experienceRepository.findById(experienceId).orElseThrow();

        return new DetailExperienceDto(experience.getExperienceId(), experience.getPosition(), experience.getInstitution(), experience.getBegined(), experience.getFinished(), experience.getDescription());
    }

    @Override
    public DetailExperienceDto create(UUID curriculumId, NewExperienceDto newExperienceDto) {
        Experience experience = new Experience();
        Curriculum curriculum = this.curriculumRepository.findById(curriculumId).orElseThrow();

        experience.setPosition(newExperienceDto.position());
        experience.setInstitution(newExperienceDto.institution());
        experience.setBegined(newExperienceDto.begined());
        experience.setFinished(newExperienceDto.finished());
        experience.setDescription(newExperienceDto.description());
        experience.setCurriculum(curriculum);

        this.experienceRepository.save(experience);

        return new DetailExperienceDto(experience.getExperienceId(), experience.getPosition(), experience.getInstitution(), experience.getBegined(), experience.getFinished(), experience.getDescription());
    }

    @Override
    public DetailExperienceDto update(UUID experienceId, UpdatedExperienceDto updatedExperienceDto) {
        Experience experience = this.experienceRepository.findById(experienceId).orElseThrow();
        experience.setPosition(updatedExperienceDto.position());
        experience.setInstitution(updatedExperienceDto.institution());
        experience.setBegined(updatedExperienceDto.begined());
        experience.setFinished(updatedExperienceDto.finished());
        experience.setDescription(updatedExperienceDto.description());

        this.experienceRepository.save(experience);

        return new DetailExperienceDto(experience.getExperienceId(), experience.getPosition(), experience.getInstitution(), experience.getBegined(), experience.getFinished(), experience.getDescription());
    }

    @Override
    public void delete(UUID experienceId) {
        this.experienceRepository.deleteById(experienceId);
    }
}
