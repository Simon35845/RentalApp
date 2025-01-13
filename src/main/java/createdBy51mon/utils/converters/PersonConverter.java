package createdBy51mon.utils.converters;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.entity.PersonEntity;

public class PersonConverter {
    public static PersonDTO toDTO(PersonEntity entity) {
        if (entity == null) {
            return null;
        }
        return PersonDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .age(entity.getAge())
                .build();
    }

    public static PersonEntity toEntity(PersonDTO dto) {
        if (dto == null) {
            return null;
        }
        return PersonEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .age(dto.getAge())
                .build();
    }
}
