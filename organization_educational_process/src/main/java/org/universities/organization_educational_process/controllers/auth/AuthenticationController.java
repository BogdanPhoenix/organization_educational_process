package org.universities.organization_educational_process.controllers.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UsersInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.Roles;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final UsersInfoSimpleService usersInfoService;
    private final RolesSimpleService rolesSimpleService;

    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @NonNull RegisterRequest request,
            Model model
    ) {
        if(usersInfoService.isExistUser(request.getEmail())){
            model.addAttribute("errorMessage",
                    String.format("The user with the email: %s has already been registered.", request.getEmail()));
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        return ResponseEntity
                .ok(service.register(request));
    }

    @GetMapping("/registration")
    public List<Roles> registrationPage(){
        var roles = rolesSimpleService.findAll();
        roles.removeIf(r -> r.getNameRole().equalsIgnoreCase("admin"));

        return roles;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authentication(request));
    }
}
