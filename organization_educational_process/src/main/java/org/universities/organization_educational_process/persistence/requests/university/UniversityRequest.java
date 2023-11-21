package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.reference_book.AccreditationLevel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityRequest {
    private AccreditationLevel accreditation;
    private String uaName;
    private String enName;
}
