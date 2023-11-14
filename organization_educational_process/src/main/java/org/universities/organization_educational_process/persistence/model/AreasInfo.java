package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "areas_info")
public class AreasInfo {
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
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @ManyToMany(mappedBy = "areas")
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<RegionsInfo> regions;

    @ManyToMany
    @JoinTable(
            name = "area_cities",
            joinColumns = @JoinColumn(name = "index_area"),
            inverseJoinColumns = @JoinColumn(name = "index_city")
    )
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<CitiesInfo> cities;
}
