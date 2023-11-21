package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;
import org.universities.organization_educational_process.persistence.model.university.Audience;

import java.util.Optional;

@Repository
@Transactional
public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Optional<Audience> findByEnclosureAndFloorNumAndAudienceNum(Enclosure enclosure, Short floorNum, Short audienceNum);
}
