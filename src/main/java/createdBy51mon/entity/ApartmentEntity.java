package createdBy51mon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apartment")
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer number;

    @Column
    private Integer floor;

    @Column
    private Integer countOfRooms;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
}
