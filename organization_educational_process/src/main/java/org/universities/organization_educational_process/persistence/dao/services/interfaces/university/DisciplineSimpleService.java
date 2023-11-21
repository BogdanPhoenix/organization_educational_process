package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.Discipline;
import org.universities.organization_educational_process.persistence.requests.university.DisciplineRequest;

public interface DisciplineSimpleService extends FindAll<Discipline>, AddComponent<DisciplineRequest>, ExistInDB<Discipline> {
}
