package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UniversitiesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UniversitiesSimpleService;

@Service
public class UniversitiesSimpleServiceImpl implements UniversitiesSimpleService {
    private UniversitiesRepository repository;

    @Autowired
    public void setRepository(UniversitiesRepository repository) {
        this.repository = repository;
    }
}
