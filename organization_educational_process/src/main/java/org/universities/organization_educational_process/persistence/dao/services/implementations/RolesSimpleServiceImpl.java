package org.universities.organization_educational_process.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.RolesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.model.Roles;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesSimpleServiceImpl implements RolesSimpleService {
    private final RolesRepository repository;

    @Override
    public List<Roles> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Roles addRole(Roles role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public Roles findByIndex(Long indexRole) {
        return repository.findByIndexRole(indexRole);
    }

    @Override
    public Roles findByName(String name) {
        return repository.findByNameRole(name);
    }

    public void deleteAllRoles() {
        repository.deleteAll();
    }
}
