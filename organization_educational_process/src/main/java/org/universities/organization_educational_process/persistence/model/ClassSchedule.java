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
@Table(name = "class_schedule", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_teacher", "index_discipline", "index_audience", "index_call"})})
public class ClassSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_class")
    private Long indexClass;

    @ManyToOne
    @JoinColumn(name = "index_teacher", nullable = false)
    @NonNull
    private Teachers teacher;

    @ManyToOne
    @JoinColumn(name = "index_discipline", nullable = false)
    @NonNull
    private Disciplines discipline;

    @ManyToOne
    @JoinColumn(name = "index_audience", nullable = false)
    @NonNull
    private Audiences audience;

    @ManyToOne
    @JoinColumn(name = "index_call", nullable = false)
    @NonNull
    private CallSchedule call;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
