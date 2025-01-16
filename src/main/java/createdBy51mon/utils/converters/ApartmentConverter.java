package createdBy51mon.utils.converters;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;

public class ApartmentConverter{
    public static ApartmentDTO toDTO(ApartmentEntity entity) {
        if (entity == null) {
            return null;
        }
        AddressDTO addressDTO = AddressConverter.toDTO(entity.getAddress());
        return ApartmentDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .floor(entity.getFloor())
                .countOfRooms(entity.getCountOfRooms())
                .totalSquare(entity.getTotalSquare())
                .address(addressDTO)
                .build();
    }

    public static ApartmentEntity toEntity(ApartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        AddressEntity addressEntity = AddressConverter.toEntity(dto.getAddress());
        return ApartmentEntity.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .floor(dto.getFloor())
                .countOfRooms(dto.getCountOfRooms())
                .totalSquare(dto.getTotalSquare())
                .address(addressEntity)
                .build();
    }
}
