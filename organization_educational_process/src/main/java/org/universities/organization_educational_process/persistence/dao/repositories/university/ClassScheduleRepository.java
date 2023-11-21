package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.university.Teacher;
import org.universities.organization_educational_process.persistence.model.university.CallSchedule;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.model.university.Discipline;

import java.util.Optional;

@Repository
@Transactional
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
    Optional<ClassSchedule> findByTeacherAndDisciplineAndAudienceAndCall(Teacher teacher, Discipline discipline, Audience audience, CallSchedule call);
}
