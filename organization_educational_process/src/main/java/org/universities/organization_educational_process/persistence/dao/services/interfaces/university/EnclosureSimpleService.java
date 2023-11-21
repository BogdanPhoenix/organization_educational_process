package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;
import org.universities.organization_educational_process.persistence.requests.university.EnclosureRequest;

public interface EnclosureSimpleService extends FindAll<Enclosure>, AddComponent<EnclosureRequest>, ExistInDB<Enclosure> {
}
