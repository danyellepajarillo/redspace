package com.redspace.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.redspace.api.domain.CaptionRequirements;

import java.util.List;

/**
 * Spring Data JPA repository for the CaptionRequirements entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CaptionRequirementsRepository extends JpaRepository<CaptionRequirements, Long> {
	List<CaptionRequirements> findByNameIgnoreCaseContaining(String name);
	boolean existsByName(String name);

}
