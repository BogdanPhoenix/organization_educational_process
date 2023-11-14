package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.GroupsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.GroupsSimpleService;

@Service
public class GroupsSimpleServiceImpl implements GroupsSimpleService {
    private GroupsRepository repository;

    @Autowired
    public void setRepository(GroupsRepository repository) {
        this.repository = repository;
    }
}
