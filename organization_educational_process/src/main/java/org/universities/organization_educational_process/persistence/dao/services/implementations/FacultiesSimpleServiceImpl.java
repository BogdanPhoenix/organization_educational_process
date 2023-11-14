package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.FacultiesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.FacultiesSimpleService;

@Service
public class FacultiesSimpleServiceImpl implements FacultiesSimpleService {
    private FacultiesRepository repository;

    @Autowired
    public void setRepository(FacultiesRepository repository) {
        this.repository = repository;
    }
}
