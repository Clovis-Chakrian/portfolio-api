package com.clovischakrian.portfolio_api.domain.repositories;

import com.clovischakrian.portfolio_api.domain.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEducationRepository extends JpaRepository<Education, UUID> {
}
