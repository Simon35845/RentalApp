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
                .apartmentNumber(entity.getApartmentNumber())
                .floor(entity.getFloor())
                .countOfRooms(entity.getCountOfRooms())
                .totalSquare(entity.getTotalSquare())
                .addressId(entity.getAddress().getId())
                .build();
    }

    public static ApartmentEntity toEntity(ApartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        return ApartmentEntity.builder()
                .id(dto.getId())
                .apartmentNumber(dto.getApartmentNumber())
                .floor(dto.getFloor())
                .countOfRooms(dto.getCountOfRooms())
                .totalSquare(dto.getTotalSquare())
                .build();
    }
}
