package org.universities.organization_educational_process.persistence.dao.services.implementations.address;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.address.AddressRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.AddressSimpleService;
import org.universities.organization_educational_process.persistence.model.address.Address;
import org.universities.organization_educational_process.persistence.requests.address.AddressRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressSimpleServiceImpl implements AddressSimpleService {
    private final AddressRepository repository;

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull AddressRequest request) {
        var address = Address.builder()
                .city(request.getCity())
                .uaNameStreet(SupportingTools
                        .formationCorrectValue(request.getUaNameStreet()))
                .enNameStreet(SupportingTools
                        .formationCorrectValue(request.getEnNameStreet()))
                .numHouse(request.getNumHouse())
                .currentData(true)
                .build();

        if(isExist(address)){
            throw new IllegalStateException("This address is already in place.");
        }

        repository.save(address);
    }

    @Override
    public boolean isExist(@NonNull Address address) {
        return repository
                .findByCityAndUaNameStreetAndNumHouse(
                        address.getCity(),
                        address.getUaNameStreet(),
                        address.getNumHouse())
                .isPresent();
    }
}
