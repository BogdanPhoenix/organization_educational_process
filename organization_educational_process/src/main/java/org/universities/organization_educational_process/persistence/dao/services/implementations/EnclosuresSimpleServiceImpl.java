package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.EnclosuresRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.EnclosuresSimpleService;

@Service
public class EnclosuresSimpleServiceImpl implements EnclosuresSimpleService {
    private EnclosuresRepository repository;

    @Autowired
    public void setRepository(EnclosuresRepository repository) {
        this.repository = repository;
    }
}
