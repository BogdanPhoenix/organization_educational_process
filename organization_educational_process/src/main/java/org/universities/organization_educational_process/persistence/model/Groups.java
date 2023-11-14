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

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_faculty", "index_curator", "index_specialty", "date_start", "date_end"})})
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_group")
    private Long indexGroup;

    @ManyToOne
    @JoinColumn(name = "index_faculty", nullable = false)
    @NonNull
    private Faculties faculty;

    @ManyToOne
    @JoinColumn(name = "index_curator", nullable = false)
    @NonNull
    private Teachers curator;

    @ManyToOne
    @JoinColumn(name = "index_specialty", nullable = false)
    @NonNull
    private Specialties specialty;

    @Column(name = "date_start", nullable = false)
    @NonNull
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    @NonNull
    private Date dateEnd;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Students> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<EJournals> eJournals;
}
