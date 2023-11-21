package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.DisciplineRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.DisciplineSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Discipline;
import org.universities.organization_educational_process.persistence.requests.university.DisciplineRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplineSimpleServiceImpl implements DisciplineSimpleService {
    private final DisciplineRepository repository;

    @Override
    public List<Discipline> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull DisciplineRequest request) {
        var discipline = Discipline.builder()
                .enNameDiscipline(SupportingTools
                        .formationCorrectValue(request.getEnNameDiscipline()))
                .uaNameDiscipline(SupportingTools
                        .formationCorrectValue(request.getUaNameDiscipline()))
                .semesterNum(request.getSemesterNum())
                .countLectures(request.getCountLectures())
                .countPractical(request.getCountPractical())
                .countCredit(request.getCountCredit())
                .currentData(true)
                .build();

        if(isExist(discipline)){
            throw new IllegalStateException("This discipline is already in place.");
        }

        repository.save(discipline);
    }

    @Override
    public boolean isExist(@NonNull Discipline value){
        return repository
                .findByEnNameDiscipline(value.getEnNameDiscipline())
                .isPresent();
    }
}
