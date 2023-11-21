package org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Attendance;

import java.util.Optional;

@Repository
@Transactional
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByEntryStudent(EntryStudent entryStudent);
}
