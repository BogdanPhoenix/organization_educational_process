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
@Table(name = "estimates", uniqueConstraints = {@UniqueConstraint(columnNames = {"estimate", "index_entry_student"})})
public class Estimates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_estimate")
    private Long indexEstimate;

    @ManyToOne
    @JoinColumn(name = "index_entry_student", nullable = false)
    @NonNull
    private EntriesStudents entryStudent;

    @Column(name = "estimate", nullable = false)
    @NonNull
    private Short estimate;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
