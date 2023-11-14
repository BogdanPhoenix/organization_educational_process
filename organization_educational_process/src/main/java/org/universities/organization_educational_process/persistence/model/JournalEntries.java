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

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "journal_entries", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_journal", "date_create"})})
public class JournalEntries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_entry")
    private Long indexEntry;

    @ManyToOne
    @JoinColumn(name = "index_journal", nullable = false)
    @NonNull
    private EJournals journal;

    @Column(name = "date_create", nullable = false)
    @NonNull
    private Date dateCreate;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<EntriesStudents> entriesStudents;
}
