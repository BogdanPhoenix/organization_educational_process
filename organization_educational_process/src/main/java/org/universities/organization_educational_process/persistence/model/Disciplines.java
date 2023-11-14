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
@Table(name = "disciplines")
public class Disciplines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_discipline")
    private Long indexDiscipline;

    @Column(name = "name_discipline", nullable = false, unique = true)
    @NonNull
    private String nameDiscipline;

    @Column(name = "semester_num", nullable = false)
    @NonNull
    private Short semesterNum;

    @Column(name = "count_lectures", nullable = false)
    @NonNull
    private Short countLectures;

    @Column(name = "count_practical", nullable = false)
    @NonNull
    private Short countPractical;

    @Column(name = "count_credit", nullable = false)
    @NonNull
    private Short countCredit;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<ClassSchedule> classSchedules;

    @ManyToMany(mappedBy = "disciplines", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Teachers> teachers;
}
