package org.universities.organization_educational_process.persistence.requests.university.ejournal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.ejournal.JournalEntry;
import org.universities.organization_educational_process.persistence.model.university.Student;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntryStudentRequest {
    private JournalEntry entry;
    private Student student;
}
