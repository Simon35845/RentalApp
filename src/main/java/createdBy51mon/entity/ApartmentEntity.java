package createdBy51mon.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"address", "landlord"})
@EqualsAndHashCode(exclude = {"address", "landlord"})
@Entity
@Table(name = "apartment", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"apartment_number", "address_id", "landlord_id"})
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", nullable = false)
    private LandlordEntity landlord;
}