package org.universities.organization_educational_process.persistence.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.CitiesInfo;

@Repository
@Transactional
public interface CitiesInfoRepository extends JpaRepository<CitiesInfo, Long> {
}