package org.universities.organization_educational_process.persistence.requests.university.ejournal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntryRequest {
    private EJournal journal;
    private Date dateCreate;
}
