package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AttendanceRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AttendanceSimpleService;

@Service
public class AttendanceSimpleServiceImpl implements AttendanceSimpleService {
    private AttendanceRepository repository;

    @Autowired
    public void setRepository(AttendanceRepository repository) {
        this.repository = repository;
    }
}
