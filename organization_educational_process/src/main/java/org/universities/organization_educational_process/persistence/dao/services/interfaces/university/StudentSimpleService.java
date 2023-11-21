package org.universities.organization_educational_process.persistence.dao.services.interfaces.university;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.model.university.Student;
import org.universities.organization_educational_process.persistence.requests.university.StudentRequest;

public interface StudentSimpleService extends AddComponent<StudentRequest>, ExistInDB<Student> {
}
