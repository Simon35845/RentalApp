package createdBy51mon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "landlord")
@PrimaryKeyJoinColumn(name = "person_id")
public class LandlordEntity extends PersonEntity {
//    @Column
//    private Double rentalCost;
/*
    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ApartmentEntity> apartments = new HashSet<>();
    */
}
