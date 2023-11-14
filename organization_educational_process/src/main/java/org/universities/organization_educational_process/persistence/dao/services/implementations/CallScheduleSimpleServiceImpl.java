package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.CallScheduleRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.CallScheduleSimpleService;

@Service
public class CallScheduleSimpleServiceImpl implements CallScheduleSimpleService {
    private CallScheduleRepository repository;

    @Autowired
    public void setRepository(CallScheduleRepository repository) {
        this.repository = repository;
    }
}
