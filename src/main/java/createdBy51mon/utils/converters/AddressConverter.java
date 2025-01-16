package createdBy51mon.utils.converters;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.entity.AddressEntity;

public class AddressConverter {
    public static AddressDTO toDTO(AddressEntity entity) {
        if (entity == null) {
            return null;
        }

        return AddressDTO.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .street(entity.getStreet())
                .houseNumber(entity.getHouseNumber())
                .build();
    }

    public static AddressEntity toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        return AddressEntity.builder()
                .id(dto.getId())
                .city(dto.getCity())
                .street(dto.getStreet())
                .houseNumber(dto.getHouseNumber())
                .build();
    }
}
