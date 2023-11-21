package org.universities.organization_educational_process.persistence.model.university.ejournal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "journal_entries", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_journal", "date_create"})
})
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_entry")
    private Long indexEntry;

    @ManyToOne
    @JoinColumn(name = "index_journal", nullable = false)
    @NonNull
    private EJournal journal;

    @Column(name = "date_create", nullable = false)
    @NonNull
    private Date dateCreate;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private EntryStudent entryStudent;
}
