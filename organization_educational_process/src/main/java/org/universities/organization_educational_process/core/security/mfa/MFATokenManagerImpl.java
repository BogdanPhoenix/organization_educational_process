package org.universities.organization_educational_process.core.security.mfa;

import dev.samstevens.totp.exceptions.QrGenerationException;
import org.springframework.stereotype.Service;

@Service("mfaTokenManager")
public class MFATokenManagerImpl implements MFATokenManager{
    @Override
    public String generateSecretKey() {
        return null;
    }

    @Override
    public String getQRCode(String secret) throws QrGenerationException {
        return null;
    }

    @Override
    public boolean verifyTotp(String code, String secret) {
        return true;
    }
}
