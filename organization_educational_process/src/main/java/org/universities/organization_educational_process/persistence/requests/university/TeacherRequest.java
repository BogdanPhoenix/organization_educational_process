package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicDegree;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicTitle;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    private Faculty faculty;
    private UserInfo user;
    private AcademicDegree degree;
    private AcademicTitle title;
}
