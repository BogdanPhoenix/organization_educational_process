package org.universities.organization_educational_process.controllers.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.config.jwt.JwtService;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UsersInfoRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(@NonNull RegisterRequest request) {
        log.info("AuthenticationService.register()");
        var user = UsersInfo.builder()
                .role(request.getRole())
                .userEmail(request.getEmail())
                .passwordUser(passwordEncoder.encode(request.getPassword()))
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .patronymic(request.getPatronymic())
                .build();

        repository.save(user);

        return getAuthenticationResponse(user);
    }

    public AuthenticationResponse authentication(@NonNull AuthenticationRequest request) {
        log.info("AuthenticationService.authentication()");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByUserEmail(request.getEmail())
                .orElseThrow();

        return getAuthenticationResponse(user);
    }

    private AuthenticationResponse getAuthenticationResponse(UsersInfo usersInfo){
        log.info("AuthenticationService.getAuthenticationResponse()");
        var jwtToken = jwtService.generateToken(usersInfo);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
