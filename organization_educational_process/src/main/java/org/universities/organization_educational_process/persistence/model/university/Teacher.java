package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicDegree;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicTitle;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_teacher")
    private Long indexTeacher;

    @ManyToOne
    @JoinColumn(name = "index_faculty", nullable = false)
    @NonNull
    private Faculty faculty;

    @OneToOne
    @JoinColumn(name = "index_user", nullable = false, unique = true)
    @NonNull
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "index_degree", nullable = false)
    @NonNull
    private AcademicDegree degree;

    @ManyToOne
    @JoinColumn(name = "index_title", nullable = false)
    @NonNull
    private AcademicTitle title;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "curator", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Group> groups;

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
    private Set<Discipline> disciplines;
}
