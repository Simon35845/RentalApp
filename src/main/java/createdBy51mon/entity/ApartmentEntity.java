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
@Table(name = "apartment", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"apartment_number", "address"})
})
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @Column
    private Integer floor;

    @Column(name = "count_of_rooms")
    private Integer countOfRooms;

    @Column(name = "total_square")
    private Double totalSquare;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
}
