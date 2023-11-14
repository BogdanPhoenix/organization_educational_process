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
@Table(name = "enclosures", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_university", "index_address"})})
public class Enclosures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_enclosure")
    private Long indexEnclosure;

    @ManyToOne
    @JoinColumn(name = "index_university", nullable = false)
    @NonNull
    private Universities university;

    @OneToOne
    @JoinColumn(name = "index_address", nullable = false, unique = true)
    @NonNull
    private Addresses address;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "enclosure", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Audiences> audiences;
}
