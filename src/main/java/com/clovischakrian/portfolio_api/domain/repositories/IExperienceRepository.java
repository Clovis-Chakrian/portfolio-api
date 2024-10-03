package com.clovischakrian.portfolio_api.domain.repositories;

import com.clovischakrian.portfolio_api.domain.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IExperienceRepository extends JpaRepository<Experience, UUID> {
}
