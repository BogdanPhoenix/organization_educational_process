package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "region_areas", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_region", "index_area"})})
public class RegionAreas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_region_area")
    private Long indexRegionArea;

    @ManyToOne
    @JoinColumn(name = "index_region", nullable = false)
    @NonNull
    private RegionsInfo region;

    @ManyToOne
    @JoinColumn(name = "index_area", nullable = false)
    @NonNull
    private AreasInfo area;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
