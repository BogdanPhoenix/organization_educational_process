package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.requests.university.FacultyRequest;

public interface FacultySimpleService extends FindAll<Faculty>, AddComponent<FacultyRequest>, ExistInDB<Faculty> {
}
