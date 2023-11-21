package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.SpecialtyRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.SpecialtySimpleService;
import org.universities.organization_educational_process.persistence.model.university.Specialty;
import org.universities.organization_educational_process.persistence.requests.university.SpecialtyRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtySimpleServiceImpl implements SpecialtySimpleService {
    private final SpecialtyRepository repository;

    @Override
    public void add(@NonNull SpecialtyRequest request) {
        var specialty = Specialty.builder()
                .uaNameSpecialty(SupportingTools
                        .formationCorrectValue(request.getUaNameSpecialty()))
                .enNameSpecialty(SupportingTools
                        .formationCorrectValue(request.getEnNameSpecialty()))
                .specialtyNum(request.getSpecialtyNum())
                .currentData(true)
                .build();

        if(isExist(specialty)){
            throw new IllegalStateException("This specialty is already in place.");
        }

        repository.save(specialty);
    }

    @Override
    public boolean isExist(@NonNull Specialty entity) {
        return repository
                .findByEnNameSpecialty(entity.getEnNameSpecialty())
                .isPresent();
    }

    @Override
    public List<Specialty> findAll() {
        return repository.findAll();
    }
}
