package org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal;

import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.AddComponent;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.ExistInDB;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts.FindAll;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Estimate;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EstimateRequest;

public interface EstimateSimpleService extends FindAll<Estimate>, AddComponent<EstimateRequest>, ExistInDB<Estimate> {
}
