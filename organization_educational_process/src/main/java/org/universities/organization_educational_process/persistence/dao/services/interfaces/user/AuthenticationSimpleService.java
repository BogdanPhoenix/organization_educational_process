package org.universities.organization_educational_process.persistence.dao.services.interfaces.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.universities.organization_educational_process.persistence.requests.user.AuthenticationRequest;
import org.universities.organization_educational_process.persistence.responses.AuthenticationResponse;
import org.universities.organization_educational_process.persistence.requests.user.RegisterRequest;

import java.io.IOException;

public interface AuthenticationSimpleService {
    AuthenticationResponse register(@NonNull RegisterRequest request);
    AuthenticationResponse authenticate(@NonNull AuthenticationRequest request);
    void refreshToken(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) throws IOException;
}
