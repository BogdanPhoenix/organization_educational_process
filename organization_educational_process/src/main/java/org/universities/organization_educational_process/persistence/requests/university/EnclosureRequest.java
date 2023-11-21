package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.University;
import org.universities.organization_educational_process.persistence.model.address.Address;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnclosureRequest {
    private University university;
    private Address address;
}
