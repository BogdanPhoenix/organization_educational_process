package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.SpecialtiesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.SpecialtiesSimpleService;

@Service
public class SpecialtiesSimpleServiceImpl implements SpecialtiesSimpleService {
    private SpecialtiesRepository repository;

    @Autowired
    public void setRepository(SpecialtiesRepository repository) {
        this.repository = repository;
    }
}
