package createdBy51mon.utils.converters;

import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.ApartmentEntity;

public class ApartmentConverter{
    public static ApartmentDTO toDTO(ApartmentEntity entity) {
        if (entity == null) {
            return null;
        }
        return ApartmentDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .floor(entity.getFloor())
                .countOfRooms(entity.getCountOfRooms())
                //.address(entity.getAddress())
                .build();
    }

    public static ApartmentEntity toEntity(ApartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        return ApartmentEntity.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .floor(dto.getFloor())
                .countOfRooms(dto.getCountOfRooms())
                //.address(dto.getAddress())
                .build();
    }
}
