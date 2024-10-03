package com.clovischakrian.portfolio_api.api.controllers;

import com.clovischakrian.portfolio_api.application.dtos.curriculums.ListCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.NewCurriculumDto;
import com.clovischakrian.portfolio_api.application.dtos.curriculums.UpdatedCurriculumDto;
import com.clovischakrian.portfolio_api.application.services.curriculum.ICurriculumService;
import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/curriculum")
@Tag(name = "Curriculum Controllers", description = "Controller to manage curriculums")
public class CurriculumController {
    @Autowired
    private ICurriculumService curriculumService;

    @PostMapping()
    @Operation(tags = "Curriculum Controllers", summary = "Create a curriculums")
    public ResponseEntity create(@RequestBody NewCurriculumDto newCurriculumDto) {
        Curriculum response = this.curriculumService.create(newCurriculumDto);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/{curriculumId}")
    @Operation(tags = "Curriculum Controllers", summary = "Update a curriculums")
    public ResponseEntity update(@PathVariable UUID curriculumId, @RequestBody UpdatedCurriculumDto updatedCurriculumDto) {
        Curriculum response = this.curriculumService.update(curriculumId, updatedCurriculumDto);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(tags = "Curriculum Controllers", summary = "List curriculum")
    public ResponseEntity list() {
        List<ListCurriculumDto> response = this.curriculumService.list();

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{curriculumId}")
    @Operation(tags = "Curriculum Controllers", summary = "Detail curriculum")
    public ResponseEntity detail(@PathVariable UUID curriculumId) {
        Curriculum response = this.curriculumService.detail(curriculumId);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{curriculumId}")
    @Operation(tags = "Curriculum Controllers", summary = "Delete curriculum")
    public ResponseEntity delete(@PathVariable UUID curriculumId) {
        this.curriculumService.delete(curriculumId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
