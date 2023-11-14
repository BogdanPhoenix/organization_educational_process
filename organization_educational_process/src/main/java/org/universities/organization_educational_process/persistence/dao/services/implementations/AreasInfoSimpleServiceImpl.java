package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AreasInfoRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AreasInfoSimpleService;

@Service
public class AreasInfoSimpleServiceImpl implements AreasInfoSimpleService {
    private AreasInfoRepository repository;

    @Autowired
    public void setRepository(AreasInfoRepository repository) {
        this.repository = repository;
    }
}
