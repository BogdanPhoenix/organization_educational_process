package org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts;

public interface ExistInDB<T> {
    boolean isExist(T entity);
}
