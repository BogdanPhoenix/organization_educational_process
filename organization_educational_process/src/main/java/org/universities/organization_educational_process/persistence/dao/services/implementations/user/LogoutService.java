package org.universities.organization_educational_process.persistence.dao.services.implementations.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.user.TokenRepository;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
    private static final String HEADER = "Authorization";
    private static final String HEADER_START_FROM = "Bearer ";

    private final TokenRepository tokenRepository;

    @Override
    public void logout(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Authentication authentication
    ) {
        final String authHeader = request.getHeader(HEADER);
        final String jwt;

        if(authHeader == null || !authHeader.startsWith(HEADER_START_FROM)) {
            return;
        }

        jwt = authHeader.substring(HEADER_START_FROM.length());
        var storedToken = tokenRepository.findByToken(jwt)
                .orElse(null);

        if(storedToken == null) {
            return;
        }

        storedToken.setExpired(true);
        storedToken.setRevoked(true);
        tokenRepository.save(storedToken);
        SecurityContextHolder.clearContext();
    }
}
