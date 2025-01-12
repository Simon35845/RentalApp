package createdBy51mon.dto;

import createdBy51mon.entity.AddressEntity;
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
    private Integer number;
    private Integer floor;
    private Integer countOfRooms;
    private AddressEntity address;
}
