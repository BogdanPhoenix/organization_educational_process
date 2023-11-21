package org.universities.organization_educational_process.persistence.dao.services.implementations.university.ejournal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal.JournalEntryRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.JournalEntrySimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.JournalEntry;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.JournalEntryRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalEntrySimpleServiceImpl implements JournalEntrySimpleService {
    private final JournalEntryRepository repository;

    @Override
    public void add(@NonNull JournalEntryRequest request) {
        var journal = JournalEntry.builder()
                .journal(request.getJournal())
                .dateCreate(request.getDateCreate())
                .currentData(true)
                .build();

        if(isExist(journal)){
            throw new IllegalStateException("This journal is already in place.");
        }

        repository.save(journal);
    }

    @Override
    public boolean isExist(@NonNull JournalEntry entity) {
        return repository
                .findByJournalAndDateCreate(
                        entity.getJournal(),
                        entity.getDateCreate()
                ).isPresent();
    }

    @Override
    public List<JournalEntry> findAll() {
        return repository.findAll();
    }
}
