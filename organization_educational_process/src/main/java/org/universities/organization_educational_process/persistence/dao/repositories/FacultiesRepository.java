package org.universities.organization_educational_process.persistence.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.Faculties;

@Repository
@Transactional
public interface FacultiesRepository extends JpaRepository<Faculties, Long> {
}
