package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "students", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_user", "index_group"})})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_student")
    private Long indexStudent;

    @OneToOne
    @JoinColumn(name = "index_user", nullable = false, unique = true)
    @NonNull
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "index_group", nullable = false)
    @NonNull
    private Group group;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<EntryStudent> entriesStudents;
}
