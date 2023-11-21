package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.university.Teacher;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.model.university.Specialty;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {
    private Faculty faculty;
    private Teacher curator;
    private Specialty specialty;
    private Date dateStart;
    private Date dateEnd;
}
