package createdBy51mon.utils.converters;

import createdBy51mon.dto.TenantDTO;
import createdBy51mon.entity.TenantEntity;

public class TenantConverter {
    public static TenantDTO toDTO(TenantEntity entity) {
        if (entity == null) {
            return null;
        }
        return TenantDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .age(entity.getAge())
                .build();
    }

    public static TenantEntity toEntity(TenantDTO dto) {
        if (dto == null) {
            return null;
        }
        return TenantEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .age(dto.getAge())
                .build();
    }
}
