package org.universities.organization_educational_process.enumarations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    UNIVERSITY_ADMIN_READ("university_admin:read"),
    UNIVERSITY_ADMIN_CREATE("university_admin:create"),

    TEACHER_READ("teacher:read"),

    STUDENT_READ("student:read");

    private final String permission;
}
