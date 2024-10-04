package com.clovischakrian.portfolio_api.api.controllers;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.ListCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.UpdatedCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.education.DetailEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.ListEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.NewEducationDto;
import com.clovischakrian.portfolio_api.application.dtos.education.UpdatedEducationDto;
import com.clovischakrian.portfolio_api.application.services.curriculum.ICurriculumService;
import com.clovischakrian.portfolio_api.application.services.education.IEducationService;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.entities.Education;
import com.clovischakrian.portfolio_api.domain.exceptions.ElementNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/curriculum/{curriculumId}/education")
@Tag(name = "Education Controllers", description = "Controller to manage education by curriculums")
public class EducationController {
    @Autowired
    private IEducationService educationService;

    @PostMapping()
    @Operation(tags = "Education Controllers", summary = "Create a education for specified curriculum")
    public ResponseEntity create(@PathVariable UUID curriculumId, @RequestBody @Valid NewEducationDto newEducationDto) throws ElementNotFoundException {
        DetailEducationDto response = this.educationService.create(curriculumId, newEducationDto);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/{educationId}")
    @Operation(tags = "Curriculum Controllers", summary = "Update a curriculums")
    public ResponseEntity update(@PathVariable UUID educationId, @RequestBody @Valid UpdatedEducationDto updatedEducationDto) throws ElementNotFoundException {
        DetailEducationDto response = this.educationService.update(educationId, updatedEducationDto);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(tags = "Education Controllers", summary = "List educations by curriculum")
    public ResponseEntity list(@PathVariable UUID curriculumId) {
        List<ListEducationDto> response = this.educationService.list(curriculumId);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{educationId}")
    @Operation(tags = "Education Controllers", summary = "Detail education")
    public ResponseEntity detail(@PathVariable UUID educationId) throws ElementNotFoundException {
        DetailEducationDto response = this.educationService.detail(educationId);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{educationId}")
    @Operation(tags = "Education Controllers", summary = "Delete education")
    public ResponseEntity delete(@PathVariable UUID educationId) {
        this.educationService.delete(educationId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
