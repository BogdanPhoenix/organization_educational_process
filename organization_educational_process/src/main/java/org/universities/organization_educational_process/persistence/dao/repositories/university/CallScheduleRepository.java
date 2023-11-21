package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.CallSchedule;

import java.sql.Time;
import java.util.Optional;

@Repository
@Transactional
public interface CallScheduleRepository extends JpaRepository<CallSchedule, Long> {
    Optional<CallSchedule> findByStartTimeAndEndTime(Time startTime, Time endTime);
}
