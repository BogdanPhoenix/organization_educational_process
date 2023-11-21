package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.university.Teacher;
import org.universities.organization_educational_process.persistence.model.university.CallSchedule;
import org.universities.organization_educational_process.persistence.model.university.Discipline;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleRequest {
    private Teacher teacher;
    private Discipline discipline;
    private Audience audience;
    private CallSchedule call;
}
