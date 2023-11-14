package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.TeachersRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.TeachersSimpleService;

@Service
public class TeachersSimpleServiceImpl implements TeachersSimpleService {
    private TeachersRepository repository;

    @Autowired
    public void setRepository(TeachersRepository repository) {
        this.repository = repository;
    }
}
