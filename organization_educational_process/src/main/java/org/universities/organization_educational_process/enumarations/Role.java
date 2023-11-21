package org.universities.organization_educational_process.enumarations;

import static org.universities.organization_educational_process.enumarations.Permission.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("Адмін", "Admin", Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE,
            UNIVERSITY_ADMIN_READ,
            UNIVERSITY_ADMIN_CREATE,
            TEACHER_READ,
            STUDENT_READ
    )),
    UNIVERSITY_ADMIN("Адміністрація університету", "University administration", Set.of(
            UNIVERSITY_ADMIN_CREATE,
            UNIVERSITY_ADMIN_READ
    )),
    TEACHER("Викладач", "Teacher", Set.of(
            TEACHER_READ
    )),
    STUDENT("Студент", "Student", Set.of(
            STUDENT_READ
    ));

    private final String uaName;
    private final String enName;
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
