package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AcademicTitlesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AcademicTitlesSimpleService;

@Service
public class AcademicTitlesSimpleServiceImpl implements AcademicTitlesSimpleService {
    private AcademicTitlesRepository repository;

    @Autowired
    public void setRepository(AcademicTitlesRepository repository) { this.repository = repository; }
}
