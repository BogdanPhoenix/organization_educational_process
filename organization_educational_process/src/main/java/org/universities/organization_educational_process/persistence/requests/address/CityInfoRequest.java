package org.universities.organization_educational_process.persistence.requests.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityInfoRequest {
    private String uaName;
    private String enName;
}
