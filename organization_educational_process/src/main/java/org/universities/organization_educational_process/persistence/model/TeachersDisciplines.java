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
@Table(name = "teachers_disciplines", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_teacher", "index_discipline"})})
public class TeachersDisciplines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_teacher_discipline")
    private Long indexTeacherDiscipline;

    @ManyToOne
    @JoinColumn(name = "index_teacher", nullable = false)
    @NonNull
    private Teachers teacher;

    @ManyToOne
    @JoinColumn(name = "index_discipline", nullable = false)
    @NonNull
    private Disciplines discipline;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
