package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyRequest {
    private String uaNameSpecialty;
    private String enNameSpecialty;
    private Short specialtyNum;
}
