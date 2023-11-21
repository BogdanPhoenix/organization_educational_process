package org.universities.organization_educational_process.persistence.dao.repositories.address;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.address.Address;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;

import java.util.Optional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByCityAndUaNameStreetAndNumHouse(
            @NonNull CityInfo city, String uaName, Short numHouse);
}
