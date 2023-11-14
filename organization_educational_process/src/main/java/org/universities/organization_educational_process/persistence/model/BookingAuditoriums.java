package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "booking_auditoriums", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_auditorium", "index_user", "start_datetime", "duration"})})
public class BookingAuditoriums {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_booking")
    private Long indexBooking;

    @ManyToOne
    @JoinColumn(name = "index_auditorium", nullable = false)
    @NonNull
    private Audiences audience;

    @ManyToOne
    @JoinColumn(name = "index_user", nullable = false)
    @NonNull
    private UsersInfo user;

    @Column(name = "start_datetime", nullable = false)
    @NonNull
    private Timestamp startDateTime;

    @Column(name = "duration", nullable = false)
    @NonNull
    private Short duration;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
