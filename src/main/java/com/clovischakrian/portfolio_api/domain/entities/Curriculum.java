package com.clovischakrian.portfolio_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "curriculums")
@Table(name = "curriculums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "curriculumId")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID curriculumId;
    private String curriculumNick;
    private String name;
    private String email;

    private String position;
    private String presentation;

    @OneToMany(mappedBy = "curriculum")
    private List<Experience> Experiences;

    @OneToMany(mappedBy = "curriculum")
    private List<Education> Education;
}
