package com.clovischakrian.portfolio_api.api.controllers;

import com.clovischakrian.portfolio_api.application.dtos.experience.DetailExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.ListExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.NewExperienceDto;
import com.clovischakrian.portfolio_api.application.dtos.experience.UpdatedExperienceDto;
import com.clovischakrian.portfolio_api.application.services.experience.IExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/curriculum/{curriculumId}/experience")
@Tag(name = "Experience Controllers", description = "Controller to manage experience by curriculums")
public class ExperienceController {
    @Autowired
    private IExperienceService experienceService;

    @PostMapping()
    @Operation(tags = "Experience Controllers", summary = "Create a experience for specified curriculum")
    public ResponseEntity create(@PathVariable UUID curriculumId, @RequestBody NewExperienceDto newExperienceDto) {
        DetailExperienceDto response = this.experienceService.create(curriculumId, newExperienceDto);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/{experienceId}")
    @Operation(tags = "Curriculum Controllers", summary = "Update a curriculums")
    public ResponseEntity update(@PathVariable UUID experienceId, @RequestBody UpdatedExperienceDto updatedExperienceDto) {
        DetailExperienceDto response = this.experienceService.update(experienceId, updatedExperienceDto);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(tags = "Experience Controllers", summary = "List experiences by curriculum")
    public ResponseEntity list(@PathVariable UUID curriculumId) {
        List<ListExperienceDto> response = this.experienceService.list(curriculumId);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{experienceId}")
    @Operation(tags = "Experience Controllers", summary = "Detail experience")
    public ResponseEntity detail(@PathVariable UUID experienceId) {
        DetailExperienceDto response = this.experienceService.detail(experienceId);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{experienceId}")
    @Operation(tags = "Experience Controllers", summary = "Delete experience")
    public ResponseEntity delete(@PathVariable UUID experienceId) {
        this.experienceService.delete(experienceId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
