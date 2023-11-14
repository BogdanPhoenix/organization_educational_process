package org.universities.organization_educational_process.persistence.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.Audiences;

@Repository
@Transactional
public interface AudiencesRepository extends JpaRepository<Audiences, Long> {
}