package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.StudentsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.StudentsSimpleService;

@Service
public class StudentsSimpleServiceImpl implements StudentsSimpleService {
    private StudentsRepository repository;

    @Autowired
    public void setRepository(StudentsRepository repository) {
        this.repository = repository;
    }
}
