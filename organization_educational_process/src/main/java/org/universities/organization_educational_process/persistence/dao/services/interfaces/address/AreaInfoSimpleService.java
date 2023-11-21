package org.universities.organization_educational_process.persistence.dao.services.interfaces.address;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.address.AreaInfo;
import org.universities.organization_educational_process.persistence.requests.address.AreaInfoRequest;

public interface AreaInfoSimpleService extends FindAll<AreaInfo>, AddComponent<AreaInfoRequest>, ExistInDB<AreaInfo> {
}
