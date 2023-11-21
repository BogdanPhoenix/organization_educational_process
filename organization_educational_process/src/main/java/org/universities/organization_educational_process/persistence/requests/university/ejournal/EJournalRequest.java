package org.universities.organization_educational_process.persistence.requests.university.ejournal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.model.university.Group;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EJournalRequest {
    private Group group;
    private ClassSchedule classSchedule;
}
