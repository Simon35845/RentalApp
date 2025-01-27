package createdBy51mon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "address", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<ApartmentEntity> apartments = new HashSet<>();
}

