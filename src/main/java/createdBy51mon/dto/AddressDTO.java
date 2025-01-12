package createdBy51mon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String city;
    private String street;
    private String houseNumber;
    private Set<ApartmentDTO> apartment = new HashSet();
}
