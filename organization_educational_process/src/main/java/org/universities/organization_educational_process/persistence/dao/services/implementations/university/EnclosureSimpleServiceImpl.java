package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.EnclosureRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.EnclosureSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;
import org.universities.organization_educational_process.persistence.requests.university.EnclosureRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnclosureSimpleServiceImpl implements EnclosureSimpleService {
    private final EnclosureRepository repository;

    @Override
    public void add(@NonNull EnclosureRequest request) {
        var enclosure = Enclosure.builder()
                .university(request.getUniversity())
                .address(request.getAddress())
                .currentData(true)
                .build();

        if(isExist(enclosure)){
            throw new IllegalStateException("This enclosure is already in place.");
        }

        repository.save(enclosure);
    }

    @Override
    public boolean isExist(@NonNull Enclosure entity) {
        return repository
                .findByUniversityAndAddress(
                        entity.getUniversity(),
                        entity.getAddress()
                ).isPresent();
    }

    @Override
    public List<Enclosure> findAll() {
        return repository.findAll();
    }
}
