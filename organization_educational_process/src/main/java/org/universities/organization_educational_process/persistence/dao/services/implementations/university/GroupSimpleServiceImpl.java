package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.GroupRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.GroupSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Group;
import org.universities.organization_educational_process.persistence.requests.university.GroupRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupSimpleServiceImpl implements GroupSimpleService {
    private final GroupRepository repository;

    @Override
    public void add(@NonNull GroupRequest request) {
        var group = Group.builder()
                .faculty(request.getFaculty())
                .curator(request.getCurator())
                .specialty(request.getSpecialty())
                .dateStart(request.getDateStart())
                .dateEnd(request.getDateEnd())
                .currentData(true)
                .build();

        if(isExist(group)){
            throw new IllegalStateException("This group is already in place.");
        }

        repository.save(group);
    }

    @Override
    public boolean isExist(@NonNull Group entity) {
        return repository
                .findByFacultyAndSpecialtyAndDateStartAndDateEnd(
                        entity.getFaculty(),
                        entity.getSpecialty(),
                        entity.getDateStart(),
                        entity.getDateEnd()
                ).isPresent();
    }

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }
}
