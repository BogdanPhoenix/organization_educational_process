package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.University;
import org.universities.organization_educational_process.persistence.model.address.Address;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;

import java.util.Optional;

@Repository
@Transactional
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
    Optional<Enclosure> findByUniversityAndAddress(University university, Address address);
}
