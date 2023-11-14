package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "attendance", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_entry_student", "presence"})})
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_ attendance")
    private Long indexAttendance;

    @ManyToOne
    @JoinColumn(name = "index_entry_student", nullable = false)
    @NonNull
    private EntriesStudents entryStudent;

    @Column(name = "presence", nullable = false)
    @NonNull
    private Boolean presence;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
