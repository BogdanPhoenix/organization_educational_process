package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.Audience;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyRequest {
    private Audience audience;
    private String uaName;
    private String enName;
}
