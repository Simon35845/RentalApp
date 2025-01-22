package createdBy51mon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDTO {
    private Integer id;
    private Integer apartmentNumber;
    private Integer floor;
    private Integer countOfRooms;
    private Double totalSquare;
    private AddressDTO address;
}
