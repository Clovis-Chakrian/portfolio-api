package com.clovischakrian.portfolio_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "education")
@Table(name = "education")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "educationId")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID educationId;
    private Date begined;
    private Date finished;
    private String institution;
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "curriculumId", referencedColumnName = "curriculumId")
    private Curriculum curriculum;
}
