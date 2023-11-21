package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.Specialty;
import org.universities.organization_educational_process.persistence.requests.university.SpecialtyRequest;

public interface SpecialtySimpleService extends FindAll<Specialty>, AddComponent<SpecialtyRequest>, ExistInDB<Specialty> {
}
