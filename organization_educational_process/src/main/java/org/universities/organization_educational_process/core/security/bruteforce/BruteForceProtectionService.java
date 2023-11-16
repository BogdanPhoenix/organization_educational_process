package org.universities.organization_educational_process.core.security.bruteforce;

import org.springframework.stereotype.Service;

@Service
public interface BruteForceProtectionService {
    void registerLoginFailure(final String username);
    void resetBruteForceCounter(final String username);
    boolean isBruteForceAttack(final String username);
}
