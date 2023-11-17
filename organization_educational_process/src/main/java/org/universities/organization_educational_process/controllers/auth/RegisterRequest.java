package org.universities.organization_educational_process.controllers.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.Roles;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Roles role;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String patronymic;
}
