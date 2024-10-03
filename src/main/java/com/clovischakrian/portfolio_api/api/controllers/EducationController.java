package com.clovischakrian.portfolio_api.api.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/curriculum/{curriculumId}/education")
@Tag(name = "Education Controllers", description = "Controller to manage education by curriculums")
public class EducationController {

}
