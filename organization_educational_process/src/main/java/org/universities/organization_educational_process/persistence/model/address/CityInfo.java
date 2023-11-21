package org.universities.organization_educational_process.persistence.model.address;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "cities_info")
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_city")
    private Long indexCity;

    @Column(name = "ua_name", nullable = false, unique = true)
    @NonNull
    private String uaName;

    @Column(name = "en_name", nullable = false, unique = true)
    @NonNull
    private String enName;

    @Column(name = "current_data")
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @ManyToMany(mappedBy = "cities")
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<AreaInfo> areas;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<Address> addresses;
}
