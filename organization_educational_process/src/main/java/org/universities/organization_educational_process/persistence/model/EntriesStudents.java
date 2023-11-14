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
@Table(name = "entries_students", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_entry", "index_student"})})
public class EntriesStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_field")
    private Long indexField;

    @ManyToOne
    @JoinColumn(name = "index_entry", nullable = false)
    @NonNull
    private JournalEntries entry;

    @ManyToOne
    @JoinColumn(name = "index_student", nullable = false)
    @NonNull
    private Students student;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "entryStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Estimates> estimates;

    @OneToMany(mappedBy = "entryStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Attendance> attendances;
}
