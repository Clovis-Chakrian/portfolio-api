package com.clovischakrian.portfolio_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "experience")
@Table(name = "experience")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "experienceId")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID experienceId;
    private String position;
    private String institution;
    private Date begined;
    private Date finished;
    private String description;

    @ManyToOne
    @JoinColumn(name = "curriculumId", referencedColumnName = "curriculumId")
    private Curriculum curriculum;
}
