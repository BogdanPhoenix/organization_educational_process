package org.universities.organization_educational_process.persistence.requests.university;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineRequest {
    private String enNameDiscipline;
    private String uaNameDiscipline;
    private Short semesterNum;
    private Short countLectures;
    private Short countPractical;
    private Short countCredit;
}
