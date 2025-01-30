package createdBy51mon.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "apartments")
@ToString(exclude = "apartments")
@Entity
@Table(name = "address", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"city", "street", "house_number"})
})
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ApartmentEntity> apartments = new HashSet<>();
}