package org.universities.organization_educational_process.persistence.dao.repositories.reference_book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicDegree;

import java.util.Optional;

@Repository
@Transactional
public interface AcademicDegreeRepository extends JpaRepository<AcademicDegree, Long> {
    Optional<AcademicDegree> findByEnName(String name);
}
