package org.universities.organization_educational_process.persistence.dao.services.interfaces.user;

import lombok.NonNull;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.requests.user.ChangePasswordRequest;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.security.Principal;

public interface UserInfoSimpleService extends FindAll<UserInfo> {
    void changePassword(
            @NonNull ChangePasswordRequest request,
            @NonNull Principal connectedUser
    );
}
