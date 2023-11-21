package org.universities.organization_educational_process.persistence.model.university.ejournal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.model.university.Group;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "e_journals", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_group", "index_class_schedule"})})
public class EJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_journal")
    private Long indexJournal;

    @ManyToOne
    @JoinColumn(name = "index_group", nullable = false)
    @NonNull
    private Group group;

    @ManyToOne
    @JoinColumn(name = "index_class_schedule", nullable = false)
    @NonNull
    private ClassSchedule classSchedule;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<JournalEntry> journalEntries;
}
