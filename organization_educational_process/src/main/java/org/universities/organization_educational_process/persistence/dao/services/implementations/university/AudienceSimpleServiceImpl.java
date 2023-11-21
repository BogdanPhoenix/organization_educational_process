package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.AudienceRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.AudienceSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.requests.university.AudienceRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceSimpleServiceImpl implements AudienceSimpleService {
    private final AudienceRepository repository;

    @Override
    public void add(@NonNull AudienceRequest request) {
        var audience = Audience.builder()
                .enclosure(request.getEnclosure())
                .floorNum(request.getFloorNum())
                .audienceNum(request.getAudienceNum())
                .currentData(true)
                .build();

        if(isExist(audience)){
            throw new IllegalStateException("This audience schedule is already in place.");
        }

        repository.save(audience);
    }

    @Override
    public boolean isExist(Audience entity) {
        return repository
                .findByEnclosureAndFloorNumAndAudienceNum(
                        entity.getEnclosure(),
                        entity.getFloorNum(),
                        entity.getAudienceNum()
                ).isPresent();
    }

    @Override
    public List<Audience> findAll() {
        return repository.findAll();
    }
}
