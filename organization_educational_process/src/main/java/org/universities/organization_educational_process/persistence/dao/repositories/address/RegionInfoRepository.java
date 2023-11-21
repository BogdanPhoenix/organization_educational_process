package org.universities.organization_educational_process.persistence.dao.repositories.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.address.RegionInfo;

import java.util.Optional;

@Repository
@Transactional
public interface RegionInfoRepository extends JpaRepository<RegionInfo, Long> {
    Optional<RegionInfo> findByEnName(String enName);
}
