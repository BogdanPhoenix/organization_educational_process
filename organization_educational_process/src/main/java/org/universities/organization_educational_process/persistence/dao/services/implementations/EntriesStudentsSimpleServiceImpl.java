package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.EntriesStudentsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.EntriesStudentsSimpleService;

@Service
public class EntriesStudentsSimpleServiceImpl implements EntriesStudentsSimpleService {
    private EntriesStudentsRepository repository;

    @Autowired
    public void setRepository(EntriesStudentsRepository repository) {
        this.repository = repository;
    }
}
