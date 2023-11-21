package org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.model.university.Group;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;

import java.util.Optional;

@Repository
@Transactional
public interface EJournalRepository extends JpaRepository<EJournal, Long> {
    Optional<EJournal> findByGroupAndClassSchedule(Group group, ClassSchedule classSchedule);
}
