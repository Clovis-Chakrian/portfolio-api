package com.clovischakrian.portfolio_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "curriculums")
@Table(name = "curriculums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "curriculumId")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID experienceId;
    private UUID curriculumId;
    private String position;
    private String institution;
    private Date begined;
    private Date finished;
    private String description;
}
