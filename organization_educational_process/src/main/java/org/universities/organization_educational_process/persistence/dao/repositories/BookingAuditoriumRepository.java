package org.universities.organization_educational_process.persistence.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.BookingAuditorium;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
@Transactional
public interface BookingAuditoriumRepository extends JpaRepository<BookingAuditorium, Long> {
    Optional<BookingAuditorium> findByAudienceAndUserAndStartDateTime(Audience audience, UserInfo user, Timestamp start);
}
