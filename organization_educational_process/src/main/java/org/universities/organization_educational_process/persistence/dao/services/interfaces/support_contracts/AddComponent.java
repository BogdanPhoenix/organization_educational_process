package org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts;

import lombok.NonNull;

public interface AddComponent<R> {
    void add(@NonNull R request);
}
