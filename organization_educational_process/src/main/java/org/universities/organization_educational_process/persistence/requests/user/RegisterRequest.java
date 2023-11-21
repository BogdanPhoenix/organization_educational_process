package org.universities.organization_educational_process.persistence.requests.user;

import lombok.*;
import org.universities.organization_educational_process.enumarations.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Role role;
    private String userEmail;
    private String passwordUser;
    private String lastName;
    private String firstName;
    private String patronymic;
}
