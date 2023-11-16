package org.universities.organization_educational_process.persistence.dao.services.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.SecureTokenRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.SecureTokenSimpleService;
import org.universities.organization_educational_process.persistence.model.SecureToken;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class SecureTokenSimpleServiceImpl implements SecureTokenSimpleService {
    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
    private static final Charset US_ASCII = StandardCharsets.US_ASCII;
    private final SecureTokenRepository repository;

    @Getter
    @Value("${jdj.secure.token.validity}")
    private int tokenValidityInSeconds;

    @Override
    public SecureToken createSecureToken() {
        String tokenValue = new String(Base64.encodeBase64URLSafeString(DEFAULT_TOKEN_GENERATOR.generateKey()).getBytes(), US_ASCII);
        SecureToken secureToken = new SecureToken();

        secureToken.setToken(tokenValue);
        secureToken.setExpireAt(LocalDateTime.now().plusSeconds(getTokenValidityInSeconds()));
        return this.saveSecureToken(secureToken);
    }

    @Override
    public SecureToken saveSecureToken(SecureToken token) {
        return repository.save(token);
    }

    @Override
    public SecureToken findByToken(String token) {
        return repository.findByToken(token);
    }

    @Override
    public void removeToken(SecureToken token) {
        repository.delete(token);
    }

    @Override
    public void removeTokenByToken(String token) {
        repository.removeByToken(token);
    }
}
