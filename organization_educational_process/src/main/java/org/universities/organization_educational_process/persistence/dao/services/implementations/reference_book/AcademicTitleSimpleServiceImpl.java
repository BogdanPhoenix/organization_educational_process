package org.universities.organization_educational_process.persistence.dao.services.implementations.reference_book;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.reference_book.AcademicTitleRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book.AcademicTitleSimpleService;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicTitle;
import org.universities.organization_educational_process.persistence.requests.reference_book.AcademicTitleRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicTitleSimpleServiceImpl implements AcademicTitleSimpleService {
    private final AcademicTitleRepository repository;

    @Override
    public List<AcademicTitle> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull AcademicTitleRequest request) {
        var title = AcademicTitle.builder()
                .enName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .uaName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .currentData(true)
                .build();

        if(isExist(title)){
            throw new IllegalStateException("This title is already in place.");
        }

        repository.save(title);
    }

    @Override
    public boolean isExist(@NonNull AcademicTitle value) {
        return repository
                .findByEnName(value.getEnName())
                .isPresent();
    }
}
