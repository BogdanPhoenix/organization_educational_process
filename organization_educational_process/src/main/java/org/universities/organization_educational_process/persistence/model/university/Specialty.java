package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_specialty")
    private Long indexSpecialty;

    @Column(name = "ua_name_specialty", nullable = false, unique = true)
    @NonNull
    private String uaNameSpecialty;

    @Column(name = "en_name_specialty", nullable = false, unique = true)
    @NonNull
    private String enNameSpecialty;

    @Column(name = "specialty_num", nullable = false, unique = true)
    @NonNull
    private Short specialtyNum;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Group> groups;
}
