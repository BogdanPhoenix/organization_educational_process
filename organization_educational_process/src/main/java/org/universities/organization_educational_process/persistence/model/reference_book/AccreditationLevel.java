package org.universities.organization_educational_process.persistence.model.reference_book;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.University;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "accreditation_levels")
public class AccreditationLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_level")
    private Long indexLevel;

    @Column(name = "accreditation", nullable = false, unique = true)
    @NonNull
    private String accreditation;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "accreditation", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<University> universities;
}
