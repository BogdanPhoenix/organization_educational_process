package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AudiencesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AudiencesSimpleService;

@Service
public class AudiencesSimpleServiceImpl implements AudiencesSimpleService {
    private AudiencesRepository repository;

    @Autowired
    public void setRepository(AudiencesRepository repository) {
        this.repository = repository;
    }
}
