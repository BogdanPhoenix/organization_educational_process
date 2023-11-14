package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AcademicDegreesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AcademicDegreesSimpleService;

@Service
public class AcademicDegreesSimpleServiceImpl implements AcademicDegreesSimpleService {
    private AcademicDegreesRepository repository;

    @Autowired
    public void setRepository(AcademicDegreesRepository repository) { this.repository = repository; }
}
