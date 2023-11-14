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
@Table(name = "e_journals", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_group", "index_class_schedule"})})
public class EJournals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_journal")
    private Long indexJournal;

    @ManyToOne
    @JoinColumn(name = "index_group", nullable = false)
    @NonNull
    private Groups group;

    @ManyToOne
    @JoinColumn(name = "index_class_schedule", nullable = false)
    @NonNull
    private ClassSchedule classSchedule;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<JournalEntries> journalEntries;
}
