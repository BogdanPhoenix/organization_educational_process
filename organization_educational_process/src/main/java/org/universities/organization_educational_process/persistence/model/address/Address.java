package org.universities.organization_educational_process.persistence.model.address;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "addresses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"index_city", "ua_name_street", "num_house"})
})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_address")
    private Long indexAddress;

    @ManyToOne
    @JoinColumn(name = "index_city", nullable = false)
    @NonNull
    private CityInfo city;

    @Column(name = "ua_name_street", nullable = false)
    @NonNull
    private String uaNameStreet;

    @Column(name = "en_name_street", nullable = false)
    @NonNull
    private String enNameStreet;

    @Column(name = "num_house", nullable = false)
    @NonNull
    private Short numHouse;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Enclosure enclosure;
}
