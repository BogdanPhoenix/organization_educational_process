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
@Table(name = "estimates", uniqueConstraints = {@UniqueConstraint(columnNames = {"estimate", "index_entry_student"})})
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_estimate")
    private Long indexEstimate;

    @OneToOne
    @JoinColumn(name = "index_entry_student", nullable = false)
    @NonNull
    private EntryStudent entryStudent;

    @Column(name = "estimate", nullable = false)
    @NonNull
    private Short estimate;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
