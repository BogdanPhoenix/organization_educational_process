package org.universities.organization_educational_process.persistence.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
public class BookingAuditoriumRequest {
    private Audience audience;
    private UserInfo user;
    private Timestamp startDateTime;
    private Short duration;
}
