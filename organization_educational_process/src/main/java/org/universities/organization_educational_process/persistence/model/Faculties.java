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
@Table(name = "faculties")
public class Faculties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_faculty")
    private Long indexFaculty;

    @OneToOne
    @JoinColumn(name = "index_audience", nullable = false, unique = true)
    @NonNull
    private Audiences audience;

    @Column(name = "ua_name")
    @NonNull
    private String uaName;

    @Column(name = "en_name")
    @NonNull
    private String enName;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Teachers> teachers;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Groups> groups;
}
