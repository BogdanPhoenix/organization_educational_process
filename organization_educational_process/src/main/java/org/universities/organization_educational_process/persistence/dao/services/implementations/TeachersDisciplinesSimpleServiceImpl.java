package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.TeachersDisciplinesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.TeachersDisciplinesSimpleService;

@Service
public class TeachersDisciplinesSimpleServiceImpl implements TeachersDisciplinesSimpleService {
    private TeachersDisciplinesRepository repository;

    @Autowired
    public void setRepository(TeachersDisciplinesRepository repository) {
        this.repository = repository;
    }
}
