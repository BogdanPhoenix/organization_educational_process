package org.universities.organization_educational_process.persistence.requests.reference_book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcademicDegreeRequest {
    private String uaName;
    private String enName;
}
