package com.clovischakrian.portfolio_api.domain.repositories;

import com.clovischakrian.portfolio_api.domain.entities.Curriculum;
import com.clovischakrian.portfolio_api.domain.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEducationRepository extends JpaRepository<Education, UUID> {
    @Query("SELECT e FROM education e JOIN curriculums c ON e.curriculum = c WHERE c.curriculumId = :curriculumId")
    public List<Education> findAllByCurriculumId(@Param("curriculumId") UUID curriculumId);
}
