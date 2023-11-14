package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.RegionsInfoRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RegionInfoSimpleService;

@Service
public class RegionInfoSimpleServiceImpl implements RegionInfoSimpleService {
    private RegionsInfoRepository repository;

    @Autowired
    public void setRepository(RegionsInfoRepository repository) {
        this.repository = repository;
    }
}
