package org.universities.organization_educational_process.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.RolesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.model.Roles;

import java.util.List;

@Service
public class RolesSimpleServiceImpl implements RolesSimpleService {
    private RolesRepository repository;

    @Autowired
    public void setRepository(RolesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Roles> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Roles addRole(Roles role) {
        return repository.save(role);
    }

    @Override
    public Roles findByIndex(Long indexRole) {
        return repository.findByIndexRole(indexRole);
    }
}
