package org.universities.organization_educational_process.persistence.dao.services.interfaces.address;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.address.Address;
import org.universities.organization_educational_process.persistence.requests.address.AddressRequest;

public interface AddressSimpleService extends FindAll<Address>, AddComponent<AddressRequest>, ExistInDB<Address> {
}
