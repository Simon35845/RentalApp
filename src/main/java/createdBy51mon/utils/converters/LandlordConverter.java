package createdBy51mon.utils.converters;

import createdBy51mon.dto.LandlordDTO;
import createdBy51mon.entity.LandlordEntity;

public class LandlordConverter {
    public static LandlordDTO toDTO(LandlordEntity entity) {
        if (entity == null) {
            return null;
        }
        return LandlordDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .age(entity.getAge())
                .build();
    }

    public static LandlordEntity toEntity(LandlordDTO dto) {
        if (dto == null) {
            return null;
        }
        return LandlordEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .age(dto.getAge())
                .build();
    }
}
