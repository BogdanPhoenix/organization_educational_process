package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;

import java.sql.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "groups", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_faculty", "index_specialty", "date_start", "date_end"})
})
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_group")
    private Long indexGroup;

    @ManyToOne
    @JoinColumn(name = "index_faculty", nullable = false)
    @NonNull
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "index_curator", nullable = false)
    @NonNull
    private Teacher curator;

    @ManyToOne
    @JoinColumn(name = "index_specialty", nullable = false)
    @NonNull
    private Specialty specialty;

    @Column(name = "date_start", nullable = false)
    @NonNull
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    @NonNull
    private Date dateEnd;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Student> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<EJournal> eJournals;
}
