package org.universities.organization_educational_process.persistence.dao.services.implementations.university.ejournal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal.EntryStudentRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EntryStudentSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EntryStudentRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryStudentSimpleServiceImpl implements EntryStudentSimpleService {
    private final EntryStudentRepository repository;

    @Override
    public void add(@NonNull EntryStudentRequest request) {
        var entry = EntryStudent.builder()
                .entry(request.getEntry())
                .student(request.getStudent())
                .currentData(true)
                .build();

        if(isExist(entry)){
            throw new IllegalStateException("This entry student is already in place.");
        }

        repository.save(entry);
    }

    @Override
    public boolean isExist(@NonNull EntryStudent entity) {
        return repository
                .findByEntryAndStudent(
                        entity.getEntry(),
                        entity.getStudent()
                ).isPresent();
    }

    @Override
    public List<EntryStudent> findAll() {
        return repository.findAll();
    }
}
