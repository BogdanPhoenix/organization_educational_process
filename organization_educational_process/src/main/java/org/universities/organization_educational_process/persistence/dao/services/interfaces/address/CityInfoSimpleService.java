package org.universities.organization_educational_process.persistence.dao.services.interfaces.address;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;
import org.universities.organization_educational_process.persistence.requests.address.CityInfoRequest;

public interface CityInfoSimpleService extends FindAll<CityInfo>, AddComponent<CityInfoRequest>, ExistInDB<CityInfo> {
}
