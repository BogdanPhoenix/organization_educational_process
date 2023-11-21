package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.StudentRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.StudentSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Student;
import org.universities.organization_educational_process.persistence.requests.university.StudentRequest;

@Service
@RequiredArgsConstructor
public class StudentSimpleServiceImpl implements StudentSimpleService {
    private final StudentRepository repository;

    @Override
    public void add(@NonNull StudentRequest request) {
        var student = Student.builder()
                .user(request.getUser())
                .group(request.getGroup())
                .currentData(true)
                .build();

        if(isExist(student)){
            throw new IllegalStateException("This student is already in place.");
        }

        repository.save(student);
    }

    @Override
    public boolean isExist(@NonNull Student entity) {
        return repository
                .findByUserAndGroup(
                        entity.getUser(),
                        entity.getGroup()
                ).isPresent();
    }
}
