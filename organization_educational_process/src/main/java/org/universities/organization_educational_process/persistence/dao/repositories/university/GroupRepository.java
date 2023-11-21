package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.model.university.Group;
import org.universities.organization_educational_process.persistence.model.university.Specialty;

import java.sql.Date;
import java.util.Optional;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByFacultyAndSpecialtyAndDateStartAndDateEnd(
            Faculty faculty, Specialty specialty, Date start, Date end
    );
}
