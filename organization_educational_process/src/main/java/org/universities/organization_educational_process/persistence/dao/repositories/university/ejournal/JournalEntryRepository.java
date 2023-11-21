package org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;
import org.universities.organization_educational_process.persistence.model.university.ejournal.JournalEntry;

import java.sql.Date;
import java.util.Optional;

@Repository
@Transactional
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
    Optional<JournalEntry> findByJournalAndDateCreate(EJournal journal, Date date);
}
