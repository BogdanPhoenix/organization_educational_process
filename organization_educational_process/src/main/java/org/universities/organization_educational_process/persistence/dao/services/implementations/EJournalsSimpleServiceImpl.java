package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.EJournalsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.EJournalsSimpleService;

@Service
public class EJournalsSimpleServiceImpl implements EJournalsSimpleService {
    private EJournalsRepository repository;

    @Autowired
    public void setRepository(EJournalsRepository repository) {
        this.repository = repository;
    }
}
