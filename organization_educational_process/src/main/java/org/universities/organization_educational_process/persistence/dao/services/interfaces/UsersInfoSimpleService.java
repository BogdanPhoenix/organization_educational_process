package org.universities.organization_educational_process.persistence.dao.services.interfaces;

import org.universities.organization_educational_process.persistence.model.UsersInfo;

import java.util.List;

public interface UsersInfoSimpleService {
    boolean isExistUser(UsersInfo user);
    UsersInfo createUser(UsersInfo user);
    List<UsersInfo> findAll();
    void deleteAllUsers();
    void sendRegistrationConfirmationEmail(UsersInfo user);
}
