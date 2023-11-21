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
@Table(name = "areas_info")
public class AreaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_area")
    private Long indexArea;

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

    @ManyToMany(mappedBy = "areas")
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<RegionInfo> regions;

    @ManyToMany
    @JoinTable(
            name = "area_cities",
            joinColumns = @JoinColumn(name = "index_area"),
            inverseJoinColumns = @JoinColumn(name = "index_city")
    )
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<CityInfo> cities;
}
