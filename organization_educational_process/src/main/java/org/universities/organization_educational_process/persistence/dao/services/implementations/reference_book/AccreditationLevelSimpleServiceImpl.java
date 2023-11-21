package org.universities.organization_educational_process.persistence.dao.services.implementations.reference_book;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.reference_book.AccreditationLevelsRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book.AccreditationLevelSimpleService;
import org.universities.organization_educational_process.persistence.model.reference_book.AccreditationLevel;
import org.universities.organization_educational_process.persistence.requests.reference_book.AccreditationLevelRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccreditationLevelSimpleServiceImpl implements AccreditationLevelSimpleService {
    private final AccreditationLevelsRepository repository;

    @Override
    public List<AccreditationLevel> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull AccreditationLevelRequest request) {
        var level = AccreditationLevel.builder()
                .accreditation(SupportingTools
                        .formationCorrectValue(request.getAccreditation()))
                .currentData(true)
                .build();

        if(isExist(level)){
            throw new IllegalStateException("This accreditation level is already in place.");
        }

        repository.save(level);
    }

    @Override
    public boolean isExist(@NonNull AccreditationLevel value) {
        return repository
                .findByAccreditation(value.getAccreditation())
                .isPresent();
    }
}
