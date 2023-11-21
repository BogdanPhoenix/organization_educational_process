package org.universities.organization_educational_process.persistence.dao.services.implementations.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.requests.user.AuthenticationRequest;
import org.universities.organization_educational_process.persistence.responses.AuthenticationResponse;
import org.universities.organization_educational_process.persistence.requests.user.RegisterRequest;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.user.AuthenticationSimpleService;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.JwtSimpleService;
import org.universities.organization_educational_process.persistence.model.user.Token;
import org.universities.organization_educational_process.persistence.dao.repositories.user.TokenRepository;
import org.universities.organization_educational_process.enumarations.TokenType;
import org.universities.organization_educational_process.persistence.dao.repositories.user.UserInfoRepository;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationSimpleServiceImpl implements AuthenticationSimpleService {
    private final UserInfoRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSimpleService jwtSimpleService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(@NonNull RegisterRequest request){
        var user = UserInfo.builder()
                .role(request.getRole())
                .userEmail(request.getUserEmail())
                .passwordUser(passwordEncoder.encode(request.getPasswordUser()))
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .patronymic(request.getPatronymic())
                .currentData(true)
                .build();

        var savedUser = repository.save(user);
        var jwtToken = jwtSimpleService.generateToken(user);
        var refreshToken = jwtSimpleService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(@NonNull AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository
                .findByUserEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtSimpleService.generateToken(user);
        var refreshToken = jwtSimpleService.generateRefreshToken(user);

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(UserInfo user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .currentData(true)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(UserInfo user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getIndexUser());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public void refreshToken(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtSimpleService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByUserEmail(userEmail)
                    .orElseThrow();
            if (jwtSimpleService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtSimpleService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
