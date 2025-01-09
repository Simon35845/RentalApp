package createdBy51mon.utils;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.entity.PersonEntity;

public class PersonConverter {
    /**
     * Метод конвертирует {@code PersonEntity} в {@code PersonDTO}
     * @param entity входной объект типа {@code PersonEntity}
     * @return объект типа {@code PersonDTO}
     */
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

    /**
     * Метод конвертирует {@code PersonDTO} в {@code PersonEntity}
     * @param dto входной объект типа {@code PersonDTO}
     * @return объект типа {@code PersonEntity}
     */
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
