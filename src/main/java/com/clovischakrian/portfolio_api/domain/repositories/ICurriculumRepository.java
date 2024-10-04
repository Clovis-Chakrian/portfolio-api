package com.clovischakrian.portfolio_api.domain.repositories;

import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, UUID> {
}
