package com.clovischakrian.portfolio_api.domain.repositories;

import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICurriculumRepository extends JpaRepository<Curriculum, UUID> {
}
