package org.universities.organization_educational_process.persistence.model.university;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.address.Address;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "enclosures", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_university", "index_address"})
})
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_enclosure")
    private Long indexEnclosure;

    @ManyToOne
    @JoinColumn(name = "index_university", nullable = false)
    @NonNull
    private University university;

    @OneToOne
    @JoinColumn(name = "index_address", nullable = false, unique = true)
    @NonNull
    private Address address;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToMany(mappedBy = "enclosure", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Audience> audiences;
}
