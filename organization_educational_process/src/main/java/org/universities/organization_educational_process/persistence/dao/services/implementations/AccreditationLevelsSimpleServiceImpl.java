package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AccreditationLevelsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AccreditationLevelsSimpleService;

@Service
public class AccreditationLevelsSimpleServiceImpl implements AccreditationLevelsSimpleService {
    private AccreditationLevelsRepository repository;

    @Autowired
    public void setRepository(AccreditationLevelsRepository repository) { this.repository = repository; }
}
