package createdBy51mon.utils.converters;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class AddressConverter {
    public static AddressDTO toDTO(AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        Set<ApartmentDTO> dtos = entity.getApartments().stream()
                .map(ApartmentConverter::toDTO)
                .collect(Collectors.toSet());

        return AddressDTO.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .street(entity.getStreet())
                .houseNumber(entity.getHouseNumber())
                .apartments(dtos)
                .build();
    }

    public static AddressEntity toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        Set<ApartmentEntity> entities = dto.getApartments().stream()
                .map(ApartmentConverter::toEntity)
                .collect(Collectors.toSet());

        return AddressEntity.builder()
                .id(dto.getId())
                .city(dto.getCity())
                .street(dto.getStreet())
                .houseNumber(dto.getHouseNumber())
                .apartments(entities)
                .build();
    }
}
