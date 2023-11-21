package org.universities.organization_educational_process.persistence.model.university.ejournal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.Student;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "entries_students", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_entry", "index_student"})})
public class EntryStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_field")
    private Long indexField;

    @OneToOne
    @JoinColumn(name = "index_entry", nullable = false)
    @NonNull
    private JournalEntry entry;

    @ManyToOne
    @JoinColumn(name = "index_student", nullable = false)
    @NonNull
    private Student student;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "entryStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Estimate estimate;

    @OneToOne(mappedBy = "entryStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Attendance attendance;
}
