package org.universities.organization_educational_process.persistence.dao.repositories.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.address.AreaInfo;

import java.util.Optional;

@Repository
@Transactional
public interface AreaInfoRepository extends JpaRepository<AreaInfo, Long> {
    Optional<AreaInfo> findByEnName(String name);
}
