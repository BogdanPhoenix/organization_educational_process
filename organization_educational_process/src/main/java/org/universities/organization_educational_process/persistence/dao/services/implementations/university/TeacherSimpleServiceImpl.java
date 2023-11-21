package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.TeacherRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.TeacherSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Teacher;
import org.universities.organization_educational_process.persistence.requests.university.TeacherRequest;

@Service
@RequiredArgsConstructor
public class TeacherSimpleServiceImpl implements TeacherSimpleService {
    private final TeacherRepository repository;

    @Override
    public void add(@NonNull TeacherRequest request) {
        var teacher = Teacher.builder()
                .faculty(request.getFaculty())
                .user(request.getUser())
                .degree(request.getDegree())
                .title(request.getTitle())
                .currentData(true)
                .build();

        if(isExist(teacher)){
            throw new IllegalStateException("This teacher is already in place.");
        }

        repository.save(teacher);
    }

    @Override
    public boolean isExist(Teacher entity) {
        return repository
                .findByUser(entity.getUser())
                .isPresent();
    }
}
