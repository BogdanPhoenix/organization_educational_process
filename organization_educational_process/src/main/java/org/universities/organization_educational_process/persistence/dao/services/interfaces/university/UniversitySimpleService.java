package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.University;
import org.universities.organization_educational_process.persistence.requests.university.UniversityRequest;

public interface UniversitySimpleService extends FindAll<University>, AddComponent<UniversityRequest>, ExistInDB<University> {
}
