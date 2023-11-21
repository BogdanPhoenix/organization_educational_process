package org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Attendance;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.AttendanceRequest;

public interface AttendanceSimpleService extends FindAll<Attendance>, AddComponent<AttendanceRequest>, ExistInDB<Attendance> {
}
