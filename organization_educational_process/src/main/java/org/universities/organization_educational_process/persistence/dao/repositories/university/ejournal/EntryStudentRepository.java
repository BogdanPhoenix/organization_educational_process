package org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.ejournal.JournalEntry;
import org.universities.organization_educational_process.persistence.model.university.Student;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;

import java.util.Optional;

@Repository
@Transactional
public interface EntryStudentRepository extends JpaRepository<EntryStudent, Long> {
    Optional<EntryStudent> findByEntryAndStudent(JournalEntry entry, Student student);
}
