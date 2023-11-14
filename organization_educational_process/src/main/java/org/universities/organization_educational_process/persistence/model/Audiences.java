package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "audiences", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_enclosure", "floor_num", "audience_num"})})
public class Audiences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_audience")
    private Long indexAudience;

    @ManyToOne
    @JoinColumn(name = "index_enclosure", nullable = false)
    @NonNull
    private Enclosures enclosure;

    @Column(name = "floor_num", nullable = false)
    @NonNull
    private Short floorNum;

    @Column(name = "audience_num", nullable = false)
    @NonNull
    private Short audienceNum;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Faculties faculty;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<ClassSchedule> classSchedules;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<BookingAuditoriums> bookingAuditoriums;
}
