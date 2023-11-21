package org.universities.organization_educational_process.persistence.dao.repositories.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;

import java.util.Optional;

@Repository
@Transactional
public interface CityInfoRepository extends JpaRepository<CityInfo, Long> {
    Optional<CityInfo> findByEnNameAndUaName(String enName, String uaName);
}
