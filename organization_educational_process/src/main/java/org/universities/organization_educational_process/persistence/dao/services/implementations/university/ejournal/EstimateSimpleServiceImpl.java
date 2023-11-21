package org.universities.organization_educational_process.persistence.dao.services.implementations.university.ejournal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal.EstimateRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EstimateSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Estimate;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EstimateRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstimateSimpleServiceImpl implements EstimateSimpleService {
    private final EstimateRepository repository;

    @Override
    public void add(@NonNull EstimateRequest request) {
        var estimate = Estimate.builder()
                .entryStudent(request.getEntryStudent())
                .estimate(request.getEstimate())
                .currentData(true)
                .build();

        if(isExist(estimate)){
            throw new IllegalStateException("This estimate is already in place.");
        }

        repository.save(estimate);
    }

    @Override
    public boolean isExist(@NonNull Estimate entity) {
        return repository
                .findByEntryStudentAndEstimate(
                        entity.getEntryStudent(),
                        entity.getEstimate()
                ).isPresent();
    }

    @Override
    public List<Estimate> findAll() {
        return repository.findAll();
    }
}
