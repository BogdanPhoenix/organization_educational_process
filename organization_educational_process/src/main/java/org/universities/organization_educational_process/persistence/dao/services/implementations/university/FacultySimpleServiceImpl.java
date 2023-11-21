package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.FacultyRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.FacultySimpleService;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.requests.university.FacultyRequest;
import org.universities.organization_educational_process.tools.SupportingTools;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultySimpleServiceImpl implements FacultySimpleService {
    private final FacultyRepository repository;

    @Override
    public void add(@NonNull FacultyRequest request) {
        var faculty = Faculty.builder()
                .audience(request.getAudience())
                .enName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .uaName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .currentData(true)
                .build();

        if(isExist(faculty)){
            throw new IllegalStateException("This faculty is already in place.");
        }

        repository.save(faculty);
    }

    @Override
    public boolean isExist(@NonNull Faculty entity) {
        return repository
                .findByAudience(entity.getAudience())
                .isPresent();
    }

    @Override
    public List<Faculty> findAll() {
        return repository.findAll();
    }
}
