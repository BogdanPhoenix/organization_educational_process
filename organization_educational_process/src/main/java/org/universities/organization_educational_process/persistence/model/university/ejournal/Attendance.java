package org.universities.organization_educational_process.persistence.model.university.ejournal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "attendance", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_entry_student", "presence"})})
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_ attendance")
    private Long indexAttendance;

    @OneToOne
    @JoinColumn(name = "index_entry_student", nullable = false)
    @NonNull
    private EntryStudent entryStudent;

    @Column(name = "presence", nullable = false)
    @NonNull
    private Boolean presence;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
