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
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_teacher")
    private Long indexTeacher;

    @ManyToOne
    @JoinColumn(name = "index_faculty", nullable = false)
    @NonNull
    private Faculties faculty;

    @OneToOne
    @JoinColumn(name = "index_user", nullable = false, unique = true)
    @NonNull
    private UsersInfo user;

    @ManyToOne
    @JoinColumn(name = "index_degree", nullable = false)
    @NonNull
    private AcademicDegrees degree;

    @ManyToOne
    @JoinColumn(name = "index_title", nullable = false)
    @NonNull
    private AcademicTitles title;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "curator", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Groups> groups;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<ClassSchedule> classSchedules;

    @ManyToMany
    @JoinTable(
            name = "teachers_disciplines",
            joinColumns = @JoinColumn(name = "index_teacher"),
            inverseJoinColumns = @JoinColumn(name = "index_discipline")
    )
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Disciplines> disciplines;
}
