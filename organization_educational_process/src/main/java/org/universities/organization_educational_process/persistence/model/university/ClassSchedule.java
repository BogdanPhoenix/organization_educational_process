package org.universities.organization_educational_process.persistence.model.university;

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
@Table(name = "class_schedule", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_teacher", "index_discipline", "index_audience", "index_call"})
})
public class ClassSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_class")
    private Long indexClass;

    @ManyToOne
    @JoinColumn(name = "index_teacher", nullable = false)
    @NonNull
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "index_discipline", nullable = false)
    @NonNull
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "index_audience", nullable = false)
    @NonNull
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "index_call", nullable = false)
    @NonNull
    private CallSchedule call;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
