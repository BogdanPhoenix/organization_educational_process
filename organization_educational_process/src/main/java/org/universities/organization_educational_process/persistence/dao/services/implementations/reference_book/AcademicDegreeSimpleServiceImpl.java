package org.universities.organization_educational_process.persistence.dao.services.implementations.reference_book;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.reference_book.AcademicDegreeRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book.AcademicDegreeSimpleService;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicDegree;
import org.universities.organization_educational_process.persistence.requests.reference_book.AcademicDegreeRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicDegreeSimpleServiceImpl implements AcademicDegreeSimpleService {
    private final AcademicDegreeRepository repository;

    @Override
    public List<AcademicDegree> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull AcademicDegreeRequest request) {
        var degree = AcademicDegree.builder()
                .enName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .uaName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .currentData(true)
                .build();

        if(isExist(degree)){
            throw new IllegalStateException("This role is already in place.");
        }

        repository.save(degree);
    }

    @Override
    public boolean isExist(@NonNull AcademicDegree value) {
        return repository
                .findByEnName(value.getEnName())
                .isPresent();
    }
}
