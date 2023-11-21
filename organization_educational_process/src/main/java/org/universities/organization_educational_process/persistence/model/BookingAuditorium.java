package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.universities.organization_educational_process.persistence.model.university.Audience;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "booking_auditoriums", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_auditorium", "index_user", "start_datetime", "duration"})
})
public class BookingAuditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_booking")
    private Long indexBooking;

    @ManyToOne
    @JoinColumn(name = "index_auditorium", nullable = false)
    @NonNull
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "index_user", nullable = false)
    @NonNull
    private UserInfo user;

    @Column(name = "start_datetime", nullable = false)
    @NonNull
    private Timestamp startDateTime;

    @Column(name = "duration", nullable = false)
    @NonNull
    private Short duration;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
