package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.university.Faculty;

import java.util.Optional;

@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByAudience(Audience audience);
}
