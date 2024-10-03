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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID educationId;
    private UUID curriculumId;
    private Date begined;
    private Date finished;
    private String institution;
    private String courseName;
}
