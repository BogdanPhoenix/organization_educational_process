package org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Estimate;

import java.util.Optional;

@Repository
@Transactional
public interface EstimateRepository extends JpaRepository<Estimate, Long> {
    Optional<Estimate> findByEntryStudentAndEstimate(EntryStudent student, Short estimate);
}
