package org.universities.organization_educational_process.persistence.requests.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private CityInfo city;
    private String uaNameStreet;
    private String enNameStreet;
    private Short numHouse;
}
