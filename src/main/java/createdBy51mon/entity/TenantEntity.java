package createdBy51mon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuperBuilder
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "tenant")
@PrimaryKeyJoinColumn(name = "person_id")
public class TenantEntity extends PersonEntity {
//    @Column
//    private Double rentalCost;
/*
    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ApartmentEntity> apartments = new HashSet<>();
    */
}
