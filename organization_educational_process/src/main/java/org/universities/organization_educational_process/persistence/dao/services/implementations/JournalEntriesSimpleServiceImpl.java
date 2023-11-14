package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.JournalEntriesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.JournalEntriesSimpleService;

@Service
public class JournalEntriesSimpleServiceImpl implements JournalEntriesSimpleService {
    private JournalEntriesRepository repository;

    @Autowired
    public void setRepository(JournalEntriesRepository repository) {
        this.repository = repository;
    }
}
