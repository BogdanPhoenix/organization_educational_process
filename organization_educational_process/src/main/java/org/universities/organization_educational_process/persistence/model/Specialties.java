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
@Table(name = "specialties")
public class Specialties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_specialty")
    private Long indexSpecialty;

    @Column(name = "name_specialty", nullable = false, unique = true)
    @NonNull
    private String nameSpecialty;

    @Column(name = "specialty_num", nullable = false, unique = true)
    @NonNull
    private Short specialtyNum;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Groups> groups;
}
