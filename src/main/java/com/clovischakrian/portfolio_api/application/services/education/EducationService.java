package com.clovischakrian.portfolio_api.application.services.education;

import com.clovischakrian.portfolio_api.application.dtos.education.DetailEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.ListEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.NewEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.UpdatedEducationDto;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.entities.Education;
import com.clovischakrian.portfolio_api.domain.repositories.ICurriculumRepository;
import com.clovischakrian.portfolio_api.domain.repositories.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;
    @Autowired
    private ICurriculumRepository curriculumRepository;

    @Override
    public List<ListEducationDto> list(UUID curriculumId) {
        return this.educationRepository.findAllByCurriculumId(curriculumId).stream().map(education -> new ListEducationDto(education.getEducationId(), education.getBegined(), education.getFinished(), education.getInstitution(), education.getCourseName())).toList();
    }

    @Override
    public DetailEducationDto detail(UUID educationId) {
        Education education = this.educationRepository.findById(educationId).orElseThrow();

        return new DetailEducationDto(education.getEducationId(), education.getBegined(), education.getFinished(), education.getInstitution(), education.getCourseName());
    }

    @Override
    public DetailEducationDto create(UUID curriculumId, NewEducationDto newEducationDto) {
        Education education = new Education();
        Curriculum curriculum = this.curriculumRepository.findById(curriculumId).orElseThrow();

        education.setBegined(newEducationDto.begined());
        education.setFinished(newEducationDto.finished());
        education.setInstitution(newEducationDto.institution());
        education.setCourseName(newEducationDto.courseName());
        education.setCurriculum(curriculum);

        this.educationRepository.save(education);

        return new DetailEducationDto(education.getEducationId(), education.getBegined(), education.getFinished(), education.getInstitution(), education.getCourseName());
    }

    @Override
    public DetailEducationDto update(UUID educationId, UpdatedEducationDto updatedEducationDto) {
        Education education = this.educationRepository.findById(educationId).orElseThrow();
        education.setBegined(updatedEducationDto.begined());
        education.setFinished(updatedEducationDto.finished());
        education.setInstitution(updatedEducationDto.institution());
        education.setCourseName(updatedEducationDto.courseName());

        this.educationRepository.save(education);

        return new DetailEducationDto(education.getEducationId(), education.getBegined(), education.getFinished(), education.getInstitution(), education.getCourseName());
    }

    @Override
    public void delete(UUID educationId) {
        this.educationRepository.deleteById(educationId);
    }
}
