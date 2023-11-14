package org.universities.organization_educational_process.persistence.dao.services.interfaces;

import org.universities.organization_educational_process.persistence.model.UsersInfo;

public interface UsersInfoSimpleService {
    boolean isExistUser(UsersInfo user);
    void createUser(UsersInfo user);
}
