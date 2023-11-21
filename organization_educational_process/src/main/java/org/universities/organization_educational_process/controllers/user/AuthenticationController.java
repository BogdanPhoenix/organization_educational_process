package org.universities.organization_educational_process.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.universities.organization_educational_process.persistence.requests.user.AuthenticationRequest;
import org.universities.organization_educational_process.persistence.responses.AuthenticationResponse;
import org.universities.organization_educational_process.persistence.requests.user.RegisterRequest;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.user.AuthenticationSimpleService;

import java.io.IOException;

@RestController
@RequestMapping("/${application.uri.main}/${application.uri.authorization}")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationSimpleService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
}
