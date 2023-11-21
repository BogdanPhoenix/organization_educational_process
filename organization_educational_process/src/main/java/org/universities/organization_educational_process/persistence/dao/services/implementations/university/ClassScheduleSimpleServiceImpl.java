package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ClassScheduleRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ClassScheduleSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.requests.university.ClassScheduleRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassScheduleSimpleServiceImpl implements ClassScheduleSimpleService {
    private final ClassScheduleRepository repository;

    @Override
    public void add(@NonNull ClassScheduleRequest request) {
        var classSchedule = ClassSchedule.builder()
                .teacher(request.getTeacher())
                .discipline(request.getDiscipline())
                .audience(request.getAudience())
                .call(request.getCall())
                .currentData(true)
                .build();

        if(isExist(classSchedule)){
            throw new IllegalStateException("This class schedule is already in place.");
        }

        repository.save(classSchedule);
    }

    @Override
    public boolean isExist(@NonNull ClassSchedule entity) {
        return repository
                .findByTeacherAndDisciplineAndAudienceAndCall(
                        entity.getTeacher(),
                        entity.getDiscipline(),
                        entity.getAudience(),
                        entity.getCall()
                ).isPresent();
    }

    @Override
    public List<ClassSchedule> findAll() {
        return repository.findAll();
    }
}
