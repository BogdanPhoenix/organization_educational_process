package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.DisciplinesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.DisciplinesSimpleService;

@Service
public class DisciplinesSimpleServiceImpl implements DisciplinesSimpleService {
    private DisciplinesRepository repository;

    @Autowired
    public void setRepository(DisciplinesRepository repository) {
        this.repository = repository;
    }
}
