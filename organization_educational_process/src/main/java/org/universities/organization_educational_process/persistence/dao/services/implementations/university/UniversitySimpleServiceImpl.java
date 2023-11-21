package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.UniversityRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.UniversitySimpleService;
import org.universities.organization_educational_process.persistence.model.university.University;
import org.universities.organization_educational_process.persistence.requests.university.UniversityRequest;
import org.universities.organization_educational_process.tools.SupportingTools;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversitySimpleServiceImpl implements UniversitySimpleService {
    private final UniversityRepository repository;

    @Override
    public void add(@NonNull UniversityRequest request) {
        var university = University.builder()
                .accreditation(request.getAccreditation())
                .uaName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .enName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .currentData(true)
                .build();

        if(isExist(university)){
            throw new IllegalStateException("This university is already in place.");
        }

        repository.save(university);
    }

    @Override
    public boolean isExist(@NonNull University entity) {
        return repository
                .findByEnName(entity.getEnName())
                .isPresent();
    }

    @Override
    public List<University> findAll() {
        return repository.findAll();
    }
}
