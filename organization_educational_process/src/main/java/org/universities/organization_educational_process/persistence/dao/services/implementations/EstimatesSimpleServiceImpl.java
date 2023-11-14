package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.EstimatesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.EstimatesSimpleService;

@Service
public class EstimatesSimpleServiceImpl implements EstimatesSimpleService {
    private EstimatesRepository repository;

    @Autowired
    public void setRepository(EstimatesRepository repository) {
        this.repository = repository;
    }
}
