package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.BookingAuditorium;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "audiences", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_enclosure", "floor_num", "audience_num"})
})
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_audience")
    private Long indexAudience;

    @ManyToOne
    @JoinColumn(name = "index_enclosure", nullable = false)
    @NonNull
    private Enclosure enclosure;

    @Column(name = "floor_num", nullable = false)
    @NonNull
    private Short floorNum;

    @Column(name = "audience_num", nullable = false)
    @NonNull
    private Short audienceNum;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Faculty faculty;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<ClassSchedule> classSchedules;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<BookingAuditorium> bookingAuditoriums;
}
