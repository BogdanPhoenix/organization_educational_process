package org.universities.organization_educational_process.persistence.dao.services.interfaces;

import org.universities.organization_educational_process.persistence.model.SecureToken;

public interface SecureTokenSimpleService {
    SecureToken createSecureToken();
    SecureToken saveSecureToken(final SecureToken token);
    SecureToken findByToken(final String token);
    void removeToken(final SecureToken token);
    void removeTokenByToken(final String token);
}
