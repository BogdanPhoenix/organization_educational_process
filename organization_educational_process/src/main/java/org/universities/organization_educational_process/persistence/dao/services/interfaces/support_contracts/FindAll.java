package org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts;

import java.util.List;

public interface FindAll<T> {
    List<T> findAll();
}
