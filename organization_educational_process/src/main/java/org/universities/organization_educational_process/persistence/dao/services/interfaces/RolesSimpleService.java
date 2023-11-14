package org.universities.organization_educational_process.persistence.dao.services.interfaces;

import org.universities.organization_educational_process.persistence.model.Roles;

import java.util.List;

public interface RolesSimpleService {
    List<Roles> findAll();
    Roles addRole(Roles role);
    Roles findByIndex(Long indexRole);
}
