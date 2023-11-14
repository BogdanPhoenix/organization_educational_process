package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AreaCitiesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AreaCitiesSimpleService;

@Service
public class AreaCitiesSimpleServiceImpl implements AreaCitiesSimpleService {
    private AreaCitiesRepository repository;

    @Autowired
    public void setRepository(AreaCitiesRepository repository) { this.repository = repository; }
}
