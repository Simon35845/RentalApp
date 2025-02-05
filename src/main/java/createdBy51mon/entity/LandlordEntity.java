package createdBy51mon.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Data
@AllArgsConstructor
//@NoArgsConstructor
/*@EqualsAndHashCode(exclude = "apartments", callSuper = false)
@ToString(exclude = "apartments")*/
@Entity
@Table(name = "landlord")
@PrimaryKeyJoinColumn(name = "person_id")
public class LandlordEntity extends PersonEntity {
/*    @OneToMany(mappedBy = "landlord",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Set<ApartmentEntity> apartments = new HashSet<>();*/
}
