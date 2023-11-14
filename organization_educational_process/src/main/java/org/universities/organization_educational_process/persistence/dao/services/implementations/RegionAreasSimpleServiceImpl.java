package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.RegionAreasRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RegionAreasSimpleService;

@Service
public class RegionAreasSimpleServiceImpl implements RegionAreasSimpleService {
    private RegionAreasRepository repository;

    @Autowired
    public void setRepository(RegionAreasRepository repository) {
        this.repository = repository;
    }
}
