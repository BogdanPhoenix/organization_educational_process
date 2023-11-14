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
@Table(name = "area_cities", uniqueConstraints = {@UniqueConstraint(columnNames = {"index_area", "index_city"})})
public class AreaCities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_area_city")
    private Long indexRegionArea;

    @ManyToOne
    @JoinColumn(name = "index_area", nullable = false)
    @NonNull
    private AreasInfo area;

    @ManyToOne
    @JoinColumn(name = "index_city", nullable = false)
    @NonNull
    private CitiesInfo city;

    @Column(name = "current_data")
    private boolean currentData = true;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }
}
