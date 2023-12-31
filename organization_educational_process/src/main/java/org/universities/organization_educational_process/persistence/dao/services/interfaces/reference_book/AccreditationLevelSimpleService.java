package org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.reference_book.AccreditationLevel;
import org.universities.organization_educational_process.persistence.requests.reference_book.AccreditationLevelRequest;

public interface AccreditationLevelSimpleService extends FindAll<AccreditationLevel>, AddComponent<AccreditationLevelRequest>, ExistInDB<AccreditationLevel> {
}
