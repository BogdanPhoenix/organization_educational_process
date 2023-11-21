package org.universities.organization_educational_process.persistence.dao.services.implementations.university.ejournal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal.EJournalRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EJournalSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EJournalRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EJournalSimpleServiceImpl implements EJournalSimpleService {
    private final EJournalRepository repository;

    @Override
    public void add(@NonNull EJournalRequest request) {
        var journal = EJournal.builder()
                .group(request.getGroup())
                .classSchedule(request.getClassSchedule())
                .currentData(true)
                .build();

        if(isExist(journal)){
            throw new IllegalStateException("This e-journal is already in place.");
        }

        repository.save(journal);
    }

    @Override
    public boolean isExist(EJournal entity) {
        return repository
                .findByGroupAndClassSchedule(
                        entity.getGroup(),
                        entity.getClassSchedule()
                ).isPresent();
    }

    @Override
    public List<EJournal> findAll() {
        return repository.findAll();
    }
}
