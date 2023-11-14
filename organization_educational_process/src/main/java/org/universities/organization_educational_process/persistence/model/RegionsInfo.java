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
@Table(name = "regions_info")
public class RegionsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_region")
    private Long indexRegion;

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

    @ManyToMany
    @JoinTable(
            name = "region_areas",
            joinColumns = @JoinColumn(name = "index_region"),
            inverseJoinColumns = @JoinColumn(name = "index_area")
    )
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private Set<AreasInfo> areas;
}
